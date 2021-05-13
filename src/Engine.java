import java.util.Random;

public class Engine {


    int[] player1Weights, player2Weights;

    public Engine(int[] player1Weights, int[] player2Weights) {
        this.player1Weights = player1Weights;
        this.player2Weights = player2Weights;
    }

    // funkcja oceny
    public int evaluateBoard(Board board, boolean isPlayer1) {
        int evaluation = 0;

        if (isPlayer1) {
            evaluation+= evaluateBoardWinnerHeuristic(board)*player1Weights[0];
            evaluation+= evaluateBoardWellDifferenceHeuristic(board)*player1Weights[1];
            evaluation+= evaluateBoardCloseToHomeHeuristic(board)*player1Weights[2];
            evaluation+= evaluateBoardMidHolesHeuristic(board)*player1Weights[3];
            evaluation+= evaluateBoardFarFromHomeHeuristic(board)*player1Weights[4];
        } else {
            evaluation+= evaluateBoardWinnerHeuristic(board)*player1Weights[0];
            evaluation+= evaluateBoardWellDifferenceHeuristic(board)*player1Weights[1];
            evaluation+= evaluateBoardCloseToHomeHeuristic(board)*player1Weights[2];
            evaluation+= evaluateBoardMidHolesHeuristic(board)*player1Weights[3];
            evaluation+= evaluateBoardFarFromHomeHeuristic(board)*player1Weights[4];
        }
        return evaluation;
    }

    public int evaluateBoardWinnerHeuristic(Board board) {
        if (board.getPlayer1well() > 24) {
            return 100;
        } else if (board.getPlayer2well() > 24) {
            return -100;
        }
        return 0;
    }

    public int evaluateBoardWellDifferenceHeuristic(Board board) {
        return board.getPlayer1well() - board.getPlayer2well();
    }

    public int evaluateBoardCloseToHomeHeuristic(Board board) {
        return (board.getPlayer1side()[4] + board.getPlayer1side()[5]) - (board.getPlayer2side()[0] + board.getPlayer2side()[1]);
    }

    public int evaluateBoardMidHolesHeuristic(Board board) {
        return (board.getPlayer1side()[2] + board.getPlayer1side()[3]) - (board.getPlayer2side()[2] + board.getPlayer2side()[3]);
    }

    public int evaluateBoardFarFromHomeHeuristic(Board board) {
        return (board.getPlayer1side()[1] + board.getPlayer1side()[2]) - (board.getPlayer2side()[4] + board.getPlayer2side()[5]);
    }


    public boolean isGameOver(Board board, int player) {
        if (player == 1) {
            for (int i = 0; i < board.getPlayer1side().length; i++) {
                if (board.getPlayer1side()[i] > 0) {
                    return false;
                }
            }
        } else if (player == 2) {
            for (int i = 0; i < board.getPlayer2side().length; i++) {
                if (board.getPlayer2side()[i] > 0) {
                    return false;
                }
            }
        } else {
            System.out.println("Error: Wrong player number!");
            return false;
        }
        board.gameIsOver();
        gameEndsPlayerHasNoMoves(board, player);
        return true;
    }

    public void gameEndsPlayerHasNoMoves(Board board, int player) {
        if (player == 1) {
            for (int i = 0; i < board.getPlayer2side().length; i++) {
                board.setPlayer2well(board.getPlayer2well() + board.getPlayer2side()[i]);
                board.getPlayer2side()[i] = 0;
            }
        } else if (player == 2) {
            for (int i = 0; i < board.getPlayer1side().length; i++) {
                board.setPlayer1well(board.getPlayer1well() + board.getPlayer1side()[i]);
                board.getPlayer1side()[i] = 0;
            }
        } else {
            System.out.println("Error: Wrong player number!");
        }
    }

    public boolean isMovePossible(Board board, int player, int chosenHole) {
        if (player == 1) {
            if (board.getPlayer1side()[chosenHole] == 0) {
                return false;
            } else {
                return true;
            }
        } else if (player == 2) {
            if (board.getPlayer2side()[chosenHole] == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("wrong player number, move not allowed");
            return false;
        }
    }

    protected int makeMoveAI(Board board, Player player) { //moveAlgorithm min-max - 0, alpha-beta - 1
        boolean maximizingPlayer;
        int chosenMove = -1;
        int bestValue;
        if (board.isFirstMove) {
            board.isFirstMove = false;
            return (new Random()).nextInt(6);
        }

        if (player.getPlayerNumber() == 1) {
            maximizingPlayer = true;
            bestValue = -10000;
        } else {
            maximizingPlayer = false;
            bestValue = 10000;
        }

        for (int i = 0; i < board.getPlayer1side().length; i++) {
            Board boardAfterMove = new Board(board);
            if (isMovePossible(boardAfterMove, player.getPlayerNumber(), i)) {

                switch (player.getMoveAlgorithm()) {
                    //start min-max
                    case 0:

                        if (maximizingPlayer) {
                            boolean again = boardAfterMove.makeMove(i, 1);
                            int currentValue = minMax(boardAfterMove, player.getLvlAI(), maximizingPlayer == again);
                            if (bestValue < currentValue) {
                                chosenMove = i;
                                bestValue = currentValue;
                            }
                            break;
                        } else {
                            boolean again = boardAfterMove.makeMove(i, 2);
                            int currentValue = minMax(boardAfterMove, player.getLvlAI(), maximizingPlayer == again);
                            if (bestValue > currentValue) {
                                chosenMove = i;
                                bestValue = currentValue;
                            }
                        }
                        break;

                        //start alpha-beta
                    case 1:
                        if (maximizingPlayer) {
                            boolean again = boardAfterMove.makeMove(i, 1);
                            int currentValue = alphaBeta(boardAfterMove, player.getLvlAI(), maximizingPlayer == again,-1000000, 1000000);
                            if (bestValue < currentValue) {
                                chosenMove = i;
                                bestValue = currentValue;
                            }
                            break;
                        } else {
                            boolean again = boardAfterMove.makeMove(i, 2);
                            int currentValue = alphaBeta(boardAfterMove, player.getLvlAI(), maximizingPlayer == again,-1000000, 1000000);
                            if (bestValue > currentValue) {
                                chosenMove = i;
                                bestValue = currentValue;
                            }
                        }
                        break;
                }
            }
        }
        return chosenMove;
    }


    public int minMax(Board board, int depth, boolean maximizingPlayer) {
        int player;
        if (maximizingPlayer) {
            player = 1;
        } else {
            player = 2;
        }
        if (depth == 0 || this.isGameOver(board, player)) {
            return evaluateBoard(board, maximizingPlayer);
        }
        int value;
        if (maximizingPlayer) {
            value = -100000;
            for (int i = 0; i < board.getPlayer1side().length; i++) {
                Board boardAfterMove = new Board(board);
                if (isMovePossible(boardAfterMove, 1, i)) {
                    boolean again = boardAfterMove.makeMove(i, 1);
                    value = Math.max(value, minMax(boardAfterMove, depth - 1, maximizingPlayer == again));
                }
            }
        } else {
            value = 100000;
            for (int i = 0; i < board.getPlayer2side().length; i++) {
                Board boardAfterMove = new Board(board);
                if (isMovePossible(boardAfterMove, 2, i)) {
                    boolean again = boardAfterMove.makeMove(i, 2);
                    value = Math.min(value, minMax(boardAfterMove, depth - 1, maximizingPlayer == again));
                }
            }
        }
        return value;
    }

    public int alphaBeta(Board board, int depth, boolean maximizingPlayer, int alpha, int beta) {
        int player;
        if (maximizingPlayer) {
            player = 1;
        } else {
            player = 2;
        }
        if (depth == 0 || this.isGameOver(board, player)) {
            return evaluateBoard(board, maximizingPlayer);
        }
        int value;
        if (maximizingPlayer) {
            value = -100000;
            for (int i = 0; i < board.getPlayer1side().length; i++) {
                Board boardAfterMove = new Board(board);
                if (isMovePossible(boardAfterMove, 1, i)) {
                    boolean again = boardAfterMove.makeMove(i, 1);
                    value = Math.max(value, alphaBeta(boardAfterMove, depth - 1, maximizingPlayer == again, alpha, beta));
                    alpha = Math.max(alpha, value);
                    if (alpha >= beta) {
                        break;
                    }
                }
            }
        } else {
            value = 100000;
            for (int i = 0; i < board.getPlayer2side().length; i++) {
                Board boardAfterMove = new Board(board);
                if (isMovePossible(boardAfterMove, 2, i)) {
                    boolean again = boardAfterMove.makeMove(i, 2);
                    value = Math.min(value, alphaBeta(boardAfterMove, depth - 1, maximizingPlayer == again, alpha, beta));
                    beta = Math.min(beta, value);
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
        }
        return value;
    }

}
