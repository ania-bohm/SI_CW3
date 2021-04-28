import com.sun.source.util.TaskEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
//        System.out.println("in gameplay");
        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        int playerToMoveIndex = choosePlayerToStart();
        while (!board.isGameOver()) {
            while (makeMove(players[playerToMoveIndex], gui) /*&& !board.isGameOver()*/) {
            }
            playerToMoveIndex = (playerToMoveIndex + 1) % 2;
        }
    }

    public int choosePlayerToStart() {
        return 0;
    }

    public boolean makeMove(Player player, GUIBoard gui) {
//        System.out.println("In makeMove");
        gui.playersTurn(player);

        boolean repeatMove;
        if (player.isHuman()) {
            synchronized (gui) {
                try {
//                    System.out.println("In gui wait in makeMove");
                    gui.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            repeatMove = board.makeMove(gui.chosenMove, player.getPlayerNumber());
            gui.chosenMove = -1;
        } else {
            repeatMove = board.makeMove(engine.makeMoveAI(getBoard(), player), player.getPlayerNumber());
        }
        engine.isGameOver(board, player.getPlayerNumber());
        gui.updateBoard(board);

        return repeatMove;
    }
}
