import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIBoard {
    Game game;
    Board board;
    int chosenMove;
    boolean replay = false;
    boolean exitGame = false;
    //--------------------------
    JFrame jFrame;
    JPanel jPanel, jPanelBoard;
    JButton buttonPlayer1_0, buttonPlayer1_1, buttonPlayer1_2, buttonPlayer1_3, buttonPlayer1_4, buttonPlayer1_5, buttonPlayer2_0, buttonPlayer2_1, buttonPlayer2_2, buttonPlayer2_3, buttonPlayer2_4, buttonPlayer2_5;
    JLabel labelPlayer2Well, labelPlayer1Well;


    public GUIBoard() {
        jFrame = new JFrame();
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Mankala Game");
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        board = new Board(6);
        board.initialiseBoard(4);
        jPanelBoard = new JPanel();
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

        initialiseGameListeners();
    }

    public void gameStartScreen() {
        jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jPanel.setPreferredSize(new Dimension(800, 700));
        jPanel.setLayout(new GridLayout(0, 3, 1, 1));

        JLabel jLabelChooseAIHuman, jLabelChooseAILvl, jLabelPlayer1, jLabelPlayer2, jLabelChooseAlgorithm,
                jLabelWinnerHeuristic, jLabelWellDifferenceHeuristic, jLabelCloseToHomeDifferenceHeuristic,
                jLabelFarFromHomeDifferenceHeuristic, jLabelMidHolesDifferenceHeuristic;
        JButton jButtonPlay, jButtonExit, jButtonHumanAI1, jButtonHumanAI2, jButtonAIAlgorithm1, jButtonAIAlgorithm2;

        JSpinner jSpinnerAILvl1, jSpinnerAILvl2, jSpinnerWinnerHeuristicWeight1, jSpinnerWellDifferenceWeight1,
                jSpinnerWinnerHeuristicWeight2, jSpinnerWellDifferenceWeight2,
                jSpinnerCloseToHomeWeight1, jSpinnerMidHolesWeight1, jSpinnerFarFromHomeWeight1,
                jSpinnerCloseToHomeWeight2, jSpinnerMidHolesWeight2, jSpinnerFarFromHomeWeight2;

        jLabelChooseAIHuman = new JLabel("Wybierz typ gracza.");
        jLabelChooseAILvl = new JLabel("Wybierz poziom komputera.");
        jLabelPlayer1 = new JLabel("Gracz 1", SwingConstants.CENTER);
        jLabelPlayer2 = new JLabel("Gracz 2", SwingConstants.CENTER);
        jLabelChooseAlgorithm = new JLabel("Wybierz algorytm AI.");
        jLabelWinnerHeuristic = new JLabel("Tylko wygrany (waga):");
        jLabelWellDifferenceHeuristic = new JLabel("Różnica w studniach (waga):");
        jLabelCloseToHomeDifferenceHeuristic = new JLabel("Wyróżnienie pól przy studni (waga):");
        jLabelMidHolesDifferenceHeuristic = new JLabel("Wyróżnienie środkowych pól (waga):");
        jLabelFarFromHomeDifferenceHeuristic = new JLabel("Wyróżnienie pól daleko od studni (waga):");

        jButtonExit = new JButton();
        jButtonHumanAI1 = new JButton();
        jButtonHumanAI2 = new JButton();
        jButtonPlay = new JButton();
        jButtonAIAlgorithm1 = new JButton();
        jButtonAIAlgorithm2 = new JButton();

        jButtonExit.setText("Wyjście");
        jButtonPlay.setText("Graj");
        jButtonHumanAI1.setText("Człowiek");
        jButtonHumanAI2.setText("Człowiek");
        jButtonAIAlgorithm1.setText("Min-Max");
        jButtonAIAlgorithm2.setText("Min-Max");

        jSpinnerAILvl1 = new JSpinner(new SpinnerNumberModel(2, 1, 12, 1));
        jSpinnerAILvl2 = new JSpinner(new SpinnerNumberModel(2, 1, 12, 1));

        jSpinnerWinnerHeuristicWeight1 = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
        jSpinnerWellDifferenceWeight1 = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
        jSpinnerCloseToHomeWeight1 = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
        jSpinnerMidHolesWeight1 = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
        jSpinnerFarFromHomeWeight1 = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));

        jSpinnerWinnerHeuristicWeight2 = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
        jSpinnerWellDifferenceWeight2 = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
        jSpinnerCloseToHomeWeight2 = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
        jSpinnerMidHolesWeight2 = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
        jSpinnerFarFromHomeWeight2 = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));


        jButtonAIAlgorithm1.setEnabled(false);
        jSpinnerAILvl1.setEnabled(false);
        jSpinnerWinnerHeuristicWeight1.setEnabled(false);
        jSpinnerWellDifferenceWeight1.setEnabled(false);
        jSpinnerCloseToHomeWeight1.setEnabled(false);
        jSpinnerMidHolesWeight1.setEnabled(false);
        jSpinnerFarFromHomeWeight1.setEnabled(false);

        jButtonAIAlgorithm2.setEnabled(false);
        jSpinnerAILvl2.setEnabled(false);
        jSpinnerWinnerHeuristicWeight2.setEnabled(false);
        jSpinnerWellDifferenceWeight2.setEnabled(false);
        jSpinnerCloseToHomeWeight2.setEnabled(false);
        jSpinnerMidHolesWeight2.setEnabled(false);
        jSpinnerFarFromHomeWeight2.setEnabled(false);

        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitGame = true;
                jFrame.getDefaultCloseOperation();
                synchronized (GUIBoard.this) {
                    jFrame.dispose();
                    GUIBoard.this.notify();
                }
            }
        });

        jButtonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player1 = new Player(1, jButtonHumanAI1.getText().equals("Człowiek"), (int) jSpinnerAILvl1.getValue(), jButtonAIAlgorithm1.getText().equals("Alpha-Beta")? 1 : 0);
                Player player2 = new Player(2, jButtonHumanAI2.getText().equals("Człowiek"), (int) jSpinnerAILvl2.getValue(), jButtonAIAlgorithm2.getText().equals("Alpha-Beta")? 1 : 0);
                int [] p1Weights = {(int)jSpinnerWinnerHeuristicWeight1.getValue(),(int) jSpinnerWellDifferenceWeight1.getValue(),
                        (int) jSpinnerCloseToHomeWeight1.getValue(),(int) jSpinnerMidHolesWeight1.getValue(), (int) jSpinnerFarFromHomeWeight1.getValue()};
                int [] p2Weights = {(int)jSpinnerWinnerHeuristicWeight2.getValue(),(int) jSpinnerWellDifferenceWeight2.getValue(),
                        (int) jSpinnerCloseToHomeWeight2.getValue(),(int) jSpinnerMidHolesWeight2.getValue(), (int) jSpinnerFarFromHomeWeight2.getValue()};
                game = new Game(board, player1, player2, p1Weights, p2Weights);
                synchronized (GUIBoard.this) {
                    jFrame.dispose();
                    GUIBoard.this.notify();
                }
            }
        });

        jButtonHumanAI1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jButtonHumanAI1.getText().equals("Człowiek")) {
                    jButtonHumanAI1.setText("Komputer");
                    jButtonAIAlgorithm1.setEnabled(true);
                    jSpinnerAILvl1.setEnabled(true);
                    jSpinnerWinnerHeuristicWeight1.setEnabled(true);
                    jSpinnerWellDifferenceWeight1.setEnabled(true);
                    jSpinnerCloseToHomeWeight1.setEnabled(true);
                    jSpinnerMidHolesWeight1.setEnabled(true);
                    jSpinnerFarFromHomeWeight1.setEnabled(true);

                } else {
                    jButtonHumanAI1.setText("Człowiek");
                    jButtonAIAlgorithm1.setEnabled(false);
                    jSpinnerAILvl1.setEnabled(false);
                    jSpinnerWinnerHeuristicWeight1.setEnabled(false);
                    jSpinnerWellDifferenceWeight1.setEnabled(false);
                    jSpinnerCloseToHomeWeight1.setEnabled(false);
                    jSpinnerMidHolesWeight1.setEnabled(false);
                    jSpinnerFarFromHomeWeight1.setEnabled(false);
                }
            }
        });
        jButtonHumanAI2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jButtonHumanAI2.getText().equals("Człowiek")) {
                    jButtonHumanAI2.setText("Komputer");
                    jButtonAIAlgorithm2.setEnabled(true);
                    jSpinnerAILvl2.setEnabled(true);
                    jSpinnerWinnerHeuristicWeight2.setEnabled(true);
                    jSpinnerWellDifferenceWeight2.setEnabled(true);
                    jSpinnerCloseToHomeWeight2.setEnabled(true);
                    jSpinnerMidHolesWeight2.setEnabled(true);
                    jSpinnerFarFromHomeWeight2.setEnabled(true);
                } else {
                    jButtonHumanAI2.setText("Człowiek");
                    jButtonAIAlgorithm2.setEnabled(false);
                    jSpinnerAILvl2.setEnabled(false);
                    jSpinnerWinnerHeuristicWeight2.setEnabled(false);
                    jSpinnerWellDifferenceWeight2.setEnabled(false);
                    jSpinnerCloseToHomeWeight2.setEnabled(false);
                    jSpinnerMidHolesWeight2.setEnabled(false);
                    jSpinnerFarFromHomeWeight2.setEnabled(false);
                }
            }
        });

        jButtonAIAlgorithm1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jButtonAIAlgorithm1.getText().equals("Min-Max")) {
                    jButtonAIAlgorithm1.setText("Alpha-Beta");
                } else {
                    jButtonAIAlgorithm1.setText("Min-Max");
                }
            }
        });
        jButtonAIAlgorithm2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jButtonAIAlgorithm2.getText().equals("Min-Max")) {
                    jButtonAIAlgorithm2.setText("Alpha-Beta");
                } else {
                    jButtonAIAlgorithm2.setText("Min-Max");
                }
            }
        });
        jPanel.add(new JLabel());
        jPanel.add(jLabelPlayer1);
        jPanel.add(jLabelPlayer2);
        jPanel.add(jLabelChooseAIHuman);
        jPanel.add(jButtonHumanAI1);
        jPanel.add(jButtonHumanAI2);
        jPanel.add(jLabelChooseAILvl);
        jPanel.add(jSpinnerAILvl1);
        jPanel.add(jSpinnerAILvl2);
        jPanel.add(jLabelChooseAlgorithm);
        jPanel.add(jButtonAIAlgorithm1);
        jPanel.add(jButtonAIAlgorithm2);
        jPanel.add(new JLabel());
        jPanel.add(new JLabel());
        jPanel.add(new JLabel());
        jPanel.add(new JLabel("Heurystyki oceny planszy"));
        jPanel.add(new JLabel());
        jPanel.add(new JLabel());

        jPanel.add(jLabelWinnerHeuristic);
        jPanel.add(jSpinnerWinnerHeuristicWeight1);
        jPanel.add(jSpinnerWinnerHeuristicWeight2);
        jPanel.add(jLabelWellDifferenceHeuristic);
        jPanel.add(jSpinnerWellDifferenceWeight1);
        jPanel.add(jSpinnerWellDifferenceWeight2);
        jPanel.add(jLabelCloseToHomeDifferenceHeuristic);
        jPanel.add(jSpinnerCloseToHomeWeight1);
        jPanel.add(jSpinnerCloseToHomeWeight2);
        jPanel.add(jLabelMidHolesDifferenceHeuristic);
        jPanel.add(jSpinnerMidHolesWeight1);
        jPanel.add(jSpinnerMidHolesWeight2);
        jPanel.add(jLabelFarFromHomeDifferenceHeuristic);
        jPanel.add(jSpinnerFarFromHomeWeight1);
        jPanel.add(jSpinnerFarFromHomeWeight2);

        jPanel.add(new JLabel());
        jPanel.add(new JLabel());
        jPanel.add(new JLabel());
        jPanel.add(new JLabel());
        jPanel.add(jButtonPlay);
        jPanel.add(jButtonExit);
        jPanel.setVisible(true);
        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public void makeBoard(Board board) {
        jFrame.dispose();
        jPanelBoard.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jPanelBoard.setPreferredSize(new Dimension(800, 340));
        jPanelBoard.setLayout(new GridLayout(0, 8, 1, 1));

        jPanelBoard.add(new JLabel());
        jPanelBoard.add(buttonPlayer2_0);
        jPanelBoard.add(buttonPlayer2_1);
        jPanelBoard.add(buttonPlayer2_2);
        jPanelBoard.add(buttonPlayer2_3);
        jPanelBoard.add(buttonPlayer2_4);
        jPanelBoard.add(buttonPlayer2_5);
        jPanelBoard.add(new JLabel());
        jPanelBoard.add(labelPlayer2Well);

        for (int i = 0; i < 6; i++) {
            jPanelBoard.add(new JLabel());
        }

        jPanelBoard.add(labelPlayer1Well);
        jPanelBoard.add(new JLabel());
        jPanelBoard.add(buttonPlayer1_0);
        jPanelBoard.add(buttonPlayer1_1);
        jPanelBoard.add(buttonPlayer1_2);
        jPanelBoard.add(buttonPlayer1_3);
        jPanelBoard.add(buttonPlayer1_4);
        jPanelBoard.add(buttonPlayer1_5);
        jPanelBoard.setVisible(true);

        jFrame.getContentPane().removeAll();
        jFrame.setTitle("new Mankala Game");
        jFrame.add(jPanelBoard, BorderLayout.CENTER);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public void gameFinishScreen(Board board) {
        jFrame.dispose();
        jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jPanel.setPreferredSize(new Dimension(800, 600));
        jPanel.setLayout(new GridLayout(0, 2, 1, 1));
        JButton jButtonReturn = new JButton();
        JLabel jLabelWinner;
        if (board.getPlayer1well() == board.getPlayer2well()) {
            jLabelWinner = new JLabel("Remis");
        } else if (board.getPlayer1well() > board.getPlayer2well()) {
            jLabelWinner = new JLabel("Gratulacje, wygrał gracz 1.");
        } else if (board.getPlayer1well() < board.getPlayer2well()) {
            jLabelWinner = new JLabel("Gratulacje, wygrał gracz 2.");
        } else {
            jLabelWinner = new JLabel("Error: nie da sie wskazać zwycięzcy.");
            System.out.println("Error: nie da sie wskazać zwycięzcy");
        }
        jButtonReturn.setText("Powrót");

        jButtonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replay = true;
                jFrame.dispose();
                synchronized (GUIBoard.this) {
                    GUIBoard.this.notify();
                }
            }
        });

        jPanel.add(new JLabel());
        jPanel.add(jLabelWinner);
        jPanel.add(new JLabel("Gracz 1: "));
        jPanel.add(new JLabel("" + board.getPlayer1well()));
        jPanel.add(new JLabel("Gracz 2: "));
        jPanel.add(new JLabel("" + board.getPlayer2well()));
        jPanel.add(new JLabel());
        jPanel.add(jButtonReturn);

        jFrame.getContentPane().removeAll();
        jFrame.setTitle("Results");
        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public void moveMade(int chosenMove, int player) {
        JButton[] side1buttons = new JButton[]{buttonPlayer1_0, buttonPlayer1_1, buttonPlayer1_2, buttonPlayer1_3, buttonPlayer1_4, buttonPlayer1_5};
        JButton[] side2buttons = new JButton[]{buttonPlayer2_0, buttonPlayer2_1, buttonPlayer2_2, buttonPlayer2_3, buttonPlayer2_4, buttonPlayer2_5};
        if (player == 1) {
            side1buttons[chosenMove].setBackground(Color.ORANGE);
        } else {
            side2buttons[chosenMove].setBackground(Color.ORANGE);
        }
        jPanelBoard.repaint();
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
        jPanelBoard.repaint();
    }

    public void initialiseGameListeners() {
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
//        System.out.println("Kolorowanie");
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
        jPanelBoard.revalidate();
        jPanelBoard.repaint();
        jFrame.repaint();
    }
}
