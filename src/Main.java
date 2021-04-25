import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        JFrame jFrame = new JFrame("GUI");
//        jFrame.setContentPane(new GUI().panel1);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.pack();
//        jFrame.setLocationRelativeTo(null);
//        jFrame.setVisible(true);
        Board board = new Board(6);
        board.initialiseBoard(4);
        new GUIBoard(board);
    }
}
