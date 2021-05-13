import java.util.Random;

public class Game {
    private Player player1, player2;
    private Board board;
    private Engine engine;

    public Game(Board board, Player player1, Player player2, int[] player1Weights, int[] player2Weights) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        engine = new Engine(player1Weights, player2Weights);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public void gameplay(GUIBoard gui) {
        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;

        int playerToMoveIndex = choosePlayerToStart();
        while (!engine.isGameOver(board, players[playerToMoveIndex].getPlayerNumber())) {
            boolean again = true;
            while (again && !engine.isGameOver(board, players[playerToMoveIndex].getPlayerNumber())) {
                again = makeMove(players[playerToMoveIndex], gui);
            }
            playerToMoveIndex = (playerToMoveIndex + 1) % 2;
        }
        System.out.println("Gracz 1: ");
        player1.getMeasurements().displayMeasurements();
        System.out.println("Gracz 2: ");
        player2.getMeasurements().displayMeasurements();
        player1.getMeasurements().clear();
        player2.getMeasurements().clear();
    }

    public int choosePlayerToStart() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public boolean makeMove(Player player, GUIBoard gui) {
        gui.playersTurn(player);
        boolean repeatMove;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (player.isHuman()) {
            synchronized (gui) {
                try {
                    gui.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (board.isFirstMove) {
                board.isFirstMove = false;
            }
            repeatMove = board.makeMove(gui.chosenMove, player.getPlayerNumber());
            gui.chosenMove = -1;
        } else {
            player.getMeasurements().startTimer();
            int move = engine.makeMoveAI(getBoard(), player);
            player.getMeasurements().stopTimer();
            player.getMeasurements().plusCount();
            gui.moveMade(move, player.getPlayerNumber());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            repeatMove = board.makeMove(move, player.getPlayerNumber());
            gui.updateBoard(board);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        engine.isGameOver(board, player.getPlayerNumber());
        gui.updateBoard(board);

        return repeatMove;
    }
}
