import java.util.Random;

public class Game {
    private Player player1, player2;
    private Board board;
    private Engine engine;



    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        engine = new Engine(0);
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
            if(board.isFirstMove){
                board.isFirstMove = false;
            }
            repeatMove = board.makeMove(gui.chosenMove, player.getPlayerNumber());
            gui.chosenMove = -1;
        } else {
            int move = engine.makeMoveAI(getBoard(), player);
            gui.moveMade(move,player.getPlayerNumber());

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
