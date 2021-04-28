public class Engine {

    public Engine(int evaluateBoardHeuristic) {

    }


    public int evaluateBoard(int evaluationHeuristics) {
        switch (evaluationHeuristics) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return 0;
    }

    public boolean isGameOver(Board board, int player) {
        if (player == 1) {
            for (int i = 0; i < board.getPlayer1side().length; i++) {
                System.out.print(board.getPlayer1side()[i] + " ");
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
        if (player.getPlayerNumber() == 1) {
            maximizingPlayer = true;
        } else {
            maximizingPlayer = false;
        }
        int chosenMove = 0;
        switch (player.getMoveAlgorithm()) {
            case 0:
                for (int i = 0; i < board.getPlayer1side().length; i++) {
                    Board boardAfterMove = new Board(board);
                    if (isMovePossible(boardAfterMove, player.getPlayerNumber(), i)) {

                    }
                }
                return minMax(board, player.getLvlAI(), maximizingPlayer);
            case 1:
                return alphaBeta();
        }
        return 0;
    }

    public int minMax(Board board, int depth, boolean maximizingPlayer) {
        if (depth == 0 || board.isGameOver()) {
            //return evaluateBoard();
            //chwilowo
            return 1;
        }
        return 0;
    }

    public int alphaBeta() {
        return 0;
    }

}
