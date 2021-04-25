public class Player {

    private boolean isHuman;
    private int lvlAI;
    private int playerNumber;

    public int getMoveAlgorithm() {
        return moveAlgorithm;
    }

    private int moveAlgorithm;

    public boolean isHuman() {
        return isHuman;
    }

    public int getLvlAI() {
        return lvlAI;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Player(int playerNumber, boolean isHuman, int lvlAI, int moveAlgorithm) {
        this.isHuman = isHuman;
        this.lvlAI = lvlAI;
        this.playerNumber = playerNumber;
        this.moveAlgorithm = moveAlgorithm;
    }


}
