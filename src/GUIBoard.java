import javax.swing.*;
import java.awt.*;

public class GUIBoard {
    JFrame jFrame;
    JPanel jPanel;
    JButton buttonPlayer1_0, buttonPlayer1_1, buttonPlayer1_2, buttonPlayer1_3, buttonPlayer1_4, buttonPlayer1_5, buttonPlayer2_0, buttonPlayer2_1, buttonPlayer2_2, buttonPlayer2_3, buttonPlayer2_4, buttonPlayer2_5;
    JLabel labelPlayer2Well, labelPlayer1Well;

    public GUIBoard(Board board) {
        jFrame = new JFrame();
        jFrame.setResizable(false);

        jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jPanel.setPreferredSize(new Dimension(800, 340));
        jPanel.setLayout(new GridLayout(0, 8, 1, 1));

        labelPlayer1Well = new JLabel(String.valueOf(board.getPlayer1well()), SwingConstants.CENTER);
        labelPlayer2Well = new JLabel(String.valueOf(board.getPlayer2well()), SwingConstants.CENTER);

        buttonPlayer1_0 = new JButton(String.valueOf(board.getPlayer1side()[0]));
        buttonPlayer1_1 = new JButton(String.valueOf(board.getPlayer1side()[1]));
        buttonPlayer1_2 = new JButton(String.valueOf(board.getPlayer1side()[2]));
        buttonPlayer1_3 = new JButton(String.valueOf(board.getPlayer1side()[3]));
        buttonPlayer1_4 = new JButton(String.valueOf(board.getPlayer1side()[4]));
        buttonPlayer1_5 = new JButton(String.valueOf(board.getPlayer1side()[5]));
        buttonPlayer2_0 = new JButton(String.valueOf(board.getPlayer2side()[0]));
        buttonPlayer2_1 = new JButton(String.valueOf(board.getPlayer2side()[1]));
        buttonPlayer2_2 = new JButton(String.valueOf(board.getPlayer2side()[2]));
        buttonPlayer2_3 = new JButton(String.valueOf(board.getPlayer2side()[3]));
        buttonPlayer2_4 = new JButton(String.valueOf(board.getPlayer2side()[4]));
        buttonPlayer2_5 = new JButton(String.valueOf(board.getPlayer2side()[5]));

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

        jPanel.add(new JLabel());
        jPanel.add(buttonPlayer1_0);
        jPanel.add(buttonPlayer1_1);
        jPanel.add(buttonPlayer1_2);
        jPanel.add(buttonPlayer1_3);
        jPanel.add(buttonPlayer1_4);
        jPanel.add(buttonPlayer1_5);
        jPanel.add(new JLabel());
        jPanel.add(labelPlayer1Well);

        for (int i = 0; i < 6; i++) {
            jPanel.add(new JLabel());
        }

        jPanel.add(labelPlayer2Well);
        jPanel.add(new JLabel());
        jPanel.add(buttonPlayer2_0);
        jPanel.add(buttonPlayer2_1);
        jPanel.add(buttonPlayer2_2);
        jPanel.add(buttonPlayer2_3);
        jPanel.add(buttonPlayer2_4);
        jPanel.add(buttonPlayer2_5);

        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Mankala Game");
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
