public class Board {

    private int[] player1side, player2side;
    private int player1well, player2well;
    private boolean gameOver;

    public Board(int numberOfPlayerHoles) {
        player1side = new int[numberOfPlayerHoles];
        player2side = new int[numberOfPlayerHoles];
        this.player1well = 0;
        this.player2well = 0;
        this.gameOver = false;
    }

    public Board(Board board) {
        this.player1side = new int[board.player1side.length];
        this.player2side = new int[board.player2side.length];

        for (int i = 0; i < board.player1side.length; i++) {
            this.player1side[i] = board.player1side[i];
            this.player2side[i] = board.player2side[i];
        }

        this.player1well = board.player1well;
        this.player2well = board.player2well;
        this.gameOver = board.gameOver;
    }

    public void setPlayer1well(int player1well) {
        this.player1well = player1well;
    }

    public void setPlayer2well(int player2well) {
        this.player2well = player2well;
    }

    public int[] getPlayer1side() {
        return player1side;
    }

    public int[] getPlayer2side() {
        return player2side;
    }

    public int getPlayer1well() {
        return player1well;
    }

    public int getPlayer2well() {
        return player2well;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void initialiseBoard(int pebblesPerHole) {
        for (int i = 0; i < player1side.length; i++) {
            this.player1side[i] = pebblesPerHole;
            this.player2side[i] = pebblesPerHole;
        }
    }

    public void gameIsOver() {
        gameOver = true;
    }

    public boolean makeMove(int chosenHole, int side) {
        if (side == 1) {
            int numberOfPebbles = player1side[chosenHole];
            if (numberOfPebbles == 0) {
                System.out.println("It shouldn't be clicked!!");
                return true;
            }
            player1side[chosenHole] = 0;
            for (int i = chosenHole + 1; i < player1side.length; i++) {
                player1side[i]++;
                numberOfPebbles--;
                if (numberOfPebbles == 0) {
                    if (player2side[i] > 0 && player1side[i] == 1) {
                        player1well += player2side[i];
                        player1well++;
                        player2side[i] = 0;
                        player1side[i] = 0;
                    }
                    return false;
                }
            }
            while (numberOfPebbles > 0) {
                player1well++;
                numberOfPebbles--;

                if (numberOfPebbles == 0) {
                    return true;
                }

                for (int i = player2side.length - 1; i >= 0; i--) {
                    if (numberOfPebbles > 0) {
                        player2side[i]++;
                        numberOfPebbles--;
                    } else {
                        return false;
                    }
                }
                if (numberOfPebbles == 0) {
                    return false;
                }
                for (int i = 0; i < player1side.length; i++) {
                    player1side[i]++;
                    numberOfPebbles--;
                    if (numberOfPebbles == 0) {
                        if (player2side[i] > 0 && player1side[i] == 1) {
                            player1well += player2side[i];
                            player1well++;
                            player2side[i] = 0;
                            player1side[i] = 0;
                        }
                        return false;
                    }
                }
            }

        } else if (side == 2) {
            int numberOfPebbles = player2side[chosenHole];
            if (numberOfPebbles == 0) {
                System.out.println("It shouldn't be clicked!!");
                return true;
            }
            player2side[chosenHole] = 0;
            for (int i = chosenHole - 1; i >= 0; i--) {
                player2side[i]++;
                numberOfPebbles--;
                if (numberOfPebbles == 0) {
                    if (player1side[i] > 0 && player2side[i] == 1) {
                        player2well += player1side[i];
                        player2well++;
                        player1side[i] = 0;
                        player2side[i] = 0;
                    }
                    return false;
                }
            }
            while (numberOfPebbles > 0) {
                player2well++;
                numberOfPebbles--;

                if (numberOfPebbles == 0) {
                    return true;
                }

                for (int i = 0; i < player1side.length; i++) {
                    if (numberOfPebbles > 0) {
                        player1side[i]++;
                        numberOfPebbles--;
                    } else {
                        return false;
                    }
                }
                if (numberOfPebbles == 0) {
                    return false;
                }
                for (int i = player1side.length - 1; i >= 0; i--) {
                    player2side[i]++;
                    numberOfPebbles--;
                    if (numberOfPebbles == 0) {
                        if (player1side[i] > 0 && player2side[i] == 1) {
                            player2well += player1side[i];
                            player2well++;
                            player1side[i] = 0;
                            player2side[i] = 0;
                        }
                        return false;
                    }
                }
            }
        }

        System.out.println("Something gone wrong, move not repeated");
        return false;
    }
}
