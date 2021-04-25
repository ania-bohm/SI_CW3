import javax.swing.*;
import java.awt.*;

public class GUI {
    public JPanel panel1;
    private JButton buttonPlayer2_0;
    private JButton buttonPlayer2_1;
    private JButton buttonPlayer2_2;
    private JButton buttonPlayer2_3;
    private JButton buttonPlayer1_0;
    private JButton buttonPlayer1_1;
    private JButton buttonPlayer1_2;
    private JButton buttonPlayer1_3;
    private JButton buttonPlayer2_4;
    private JButton buttonPlayer2_5;
    private JButton buttonPlayer1_4;
    private JButton buttonPlayer1_5;
    private JLabel labelPlayer2Well;
    private JLabel labelPlayer1Well;

    public GUI(){
        Board board = new Board(6);
        board.initialiseBoard(4);

        panel1 = new JPanel();

        buttonPlayer1_0 = new JButton();
        buttonPlayer1_1 = new JButton();
        buttonPlayer1_2 = new JButton();
        buttonPlayer1_3 = new JButton();
        buttonPlayer1_4 = new JButton();
        buttonPlayer1_5 = new JButton();

        buttonPlayer2_0 = new JButton();
        buttonPlayer2_1 = new JButton();
        buttonPlayer2_2 = new JButton();
        buttonPlayer2_3 = new JButton();
        buttonPlayer2_4 = new JButton();
        buttonPlayer2_5 = new JButton();

        labelPlayer1Well = new JLabel();
        labelPlayer2Well = new JLabel();

        buttonPlayer1_0.setPreferredSize(new Dimension(10, 10));
        buttonPlayer2_0.setPreferredSize(new Dimension(10, 10));
        buttonPlayer1_1.setPreferredSize(new Dimension(10, 10));
        buttonPlayer2_1.setPreferredSize(new Dimension(10, 10));
        buttonPlayer1_2.setPreferredSize(new Dimension(10, 10));
        buttonPlayer2_2.setPreferredSize(new Dimension(10, 10));
        buttonPlayer1_3.setPreferredSize(new Dimension(10, 10));
        buttonPlayer2_3.setPreferredSize(new Dimension(10, 10));
        buttonPlayer1_4.setPreferredSize(new Dimension(10, 10));
        buttonPlayer2_4.setPreferredSize(new Dimension(10, 10));
        buttonPlayer1_4.setPreferredSize(new Dimension(10, 10));
        buttonPlayer2_5.setPreferredSize(new Dimension(10, 10));

        buttonPlayer1_0.setText(String.valueOf(board.getPlayer1side()[0]));
        buttonPlayer1_1.setText(String.valueOf(board.getPlayer1side()[1]));
        buttonPlayer1_2.setText(String.valueOf(board.getPlayer1side()[2]));
        buttonPlayer1_3.setText(String.valueOf(board.getPlayer1side()[3]));
        buttonPlayer1_4.setText(String.valueOf(board.getPlayer1side()[4]));
        buttonPlayer1_5.setText(String.valueOf(board.getPlayer1side()[5]));

        buttonPlayer2_0.setText(String.valueOf(board.getPlayer2side()[0]));
        buttonPlayer2_1.setText(String.valueOf(board.getPlayer2side()[1]));
        buttonPlayer2_2.setText(String.valueOf(board.getPlayer2side()[2]));
        buttonPlayer2_3.setText(String.valueOf(board.getPlayer2side()[3]));
        buttonPlayer2_4.setText(String.valueOf(board.getPlayer2side()[4]));
        buttonPlayer2_5.setText(String.valueOf(board.getPlayer2side()[5]));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
