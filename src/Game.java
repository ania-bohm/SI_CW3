import com.sun.source.util.TaskEvent;

public class Game {
    private Player player1, player2;
    private Board board;
    private Engine engine;
    private GUIBoard gui;
    private Thread guiThread;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        engine = new Engine(0);
        gui = new GUIBoard(board);
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

    public void gameplay() {
        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        int playerToMoveIndex = choosePlayerToStart();
        while (!board.isGameOver()) {
            while (makeMove(players[playerToMoveIndex])) {

            }
            ;
            playerToMoveIndex = (playerToMoveIndex + 1) % 2;
        }
    }

    public int choosePlayerToStart() {
        return 0;
    }

    public boolean makeMove(Player player) {
        gui.playersTurn(player);
        boolean repeatMove;
        if (player.isHuman()) {
            synchronized (gui) {
                try {
                    gui.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("znotifajowali mi sreda");
            repeatMove = board.makeMove(gui.chosenMove, player.getPlayerNumber());
            gui.chosenMove = -1;
        } else {
            repeatMove = board.makeMove(engine.makeMoveAI(getBoard(), player), player.getPlayerNumber());
        }
        gui.updateBoard(board);
        return repeatMove;
    }
}
