import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIBoard {
    JFrame jFrame;
    JPanel jPanel;
    JButton buttonPlayer1_0, buttonPlayer1_1, buttonPlayer1_2, buttonPlayer1_3, buttonPlayer1_4, buttonPlayer1_5, buttonPlayer2_0, buttonPlayer2_1, buttonPlayer2_2, buttonPlayer2_3, buttonPlayer2_4, buttonPlayer2_5;
    JLabel labelPlayer2Well, labelPlayer1Well;
    int chosenMove;

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

        humanMakeMove();
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
        jPanel.add(buttonPlayer2_0);
        jPanel.add(buttonPlayer2_1);
        jPanel.add(buttonPlayer2_2);
        jPanel.add(buttonPlayer2_3);
        jPanel.add(buttonPlayer2_4);
        jPanel.add(buttonPlayer2_5);
        jPanel.add(new JLabel());
        jPanel.add(labelPlayer2Well);

        for (int i = 0; i < 6; i++) {
            jPanel.add(new JLabel());
        }

        jPanel.add(labelPlayer1Well);
        jPanel.add(new JLabel());
        jPanel.add(buttonPlayer1_0);
        jPanel.add(buttonPlayer1_1);
        jPanel.add(buttonPlayer1_2);
        jPanel.add(buttonPlayer1_3);
        jPanel.add(buttonPlayer1_4);
        jPanel.add(buttonPlayer1_5);

        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Mankala Game");
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public void updateBoard(Board board) {
        labelPlayer1Well.setText(String.valueOf(board.getPlayer1well()));
        labelPlayer2Well.setText(String.valueOf(board.getPlayer2well()));

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
        jPanel.updateUI();
    }

    public void humanMakeMove() {

        buttonPlayer1_0.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 0;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }

                                              }
                                          }
        );

        buttonPlayer1_1.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 1;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }
                                              }
                                          }
        );

        buttonPlayer1_2.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 2;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }
                                              }
                                          }
        );

        buttonPlayer1_3.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 3;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }
                                              }
                                          }
        );

        buttonPlayer1_4.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 4;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }
                                              }
                                          }
        );

        buttonPlayer1_5.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 5;
                                                  ;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }
                                              }
                                          }
        );

        buttonPlayer2_0.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 0;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }
                                              }
                                          }
        );

        buttonPlayer2_1.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 1;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }
                                              }
                                          }
        );

        buttonPlayer2_2.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 2;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }
                                              }
                                          }
        );

        buttonPlayer2_3.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 3;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }
                                              }
                                          }
        );

        buttonPlayer2_4.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 4;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }
                                              }
                                          }
        );

        buttonPlayer2_5.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  chosenMove = 5;
                                                  synchronized (GUIBoard.this) {
                                                      GUIBoard.this.notify();
                                                  }
                                              }
                                          }

        );
    }

    public void playersTurn(Player player) {
        switch (player.getPlayerNumber()) {
            case 1:
                buttonPlayer1_0.setBackground(Color.green);
                buttonPlayer1_1.setBackground(Color.green);
                buttonPlayer1_2.setBackground(Color.green);
                buttonPlayer1_3.setBackground(Color.green);
                buttonPlayer1_4.setBackground(Color.green);
                buttonPlayer1_5.setBackground(Color.green);

                buttonPlayer1_0.setEnabled(true);
                buttonPlayer1_1.setEnabled(true);
                buttonPlayer1_2.setEnabled(true);
                buttonPlayer1_3.setEnabled(true);
                buttonPlayer1_4.setEnabled(true);
                buttonPlayer1_5.setEnabled(true);

                buttonPlayer2_0.setBackground(Color.lightGray);
                buttonPlayer2_1.setBackground(Color.lightGray);
                buttonPlayer2_2.setBackground(Color.lightGray);
                buttonPlayer2_3.setBackground(Color.lightGray);
                buttonPlayer2_4.setBackground(Color.lightGray);
                buttonPlayer2_5.setBackground(Color.lightGray);

                buttonPlayer2_0.setEnabled(false);
                buttonPlayer2_1.setEnabled(false);
                buttonPlayer2_2.setEnabled(false);
                buttonPlayer2_3.setEnabled(false);
                buttonPlayer2_4.setEnabled(false);
                buttonPlayer2_5.setEnabled(false);
                break;
            case 2:
                buttonPlayer1_0.setBackground(Color.lightGray);
                buttonPlayer1_1.setBackground(Color.lightGray);
                buttonPlayer1_2.setBackground(Color.lightGray);
                buttonPlayer1_3.setBackground(Color.lightGray);
                buttonPlayer1_4.setBackground(Color.lightGray);
                buttonPlayer1_5.setBackground(Color.lightGray);

                buttonPlayer1_0.setEnabled(false);
                buttonPlayer1_1.setEnabled(false);
                buttonPlayer1_2.setEnabled(false);
                buttonPlayer1_3.setEnabled(false);
                buttonPlayer1_4.setEnabled(false);
                buttonPlayer1_5.setEnabled(false);

                buttonPlayer2_0.setBackground(Color.green);
                buttonPlayer2_1.setBackground(Color.green);
                buttonPlayer2_2.setBackground(Color.green);
                buttonPlayer2_3.setBackground(Color.green);
                buttonPlayer2_4.setBackground(Color.green);
                buttonPlayer2_5.setBackground(Color.green);

                buttonPlayer2_0.setEnabled(true);
                buttonPlayer2_1.setEnabled(true);
                buttonPlayer2_2.setEnabled(true);
                buttonPlayer2_3.setEnabled(true);
                buttonPlayer2_4.setEnabled(true);
                buttonPlayer2_5.setEnabled(true);
                break;
        }
    }
}
