public class Player {
    private boolean isHuman;
    private int lvlAI;
    private int playerNumber;
    private int moveAlgorithm;
    private Measurements measurements;


    public Player(int playerNumber, boolean isHuman, int lvlAI, int moveAlgorithm) {
        this.isHuman = isHuman;
        this.lvlAI = lvlAI;
        this.playerNumber = playerNumber;
        this.moveAlgorithm = moveAlgorithm;
        this.measurements = new Measurements();
    }

    public boolean isHuman() {
        return isHuman;
    }

    public int getLvlAI() {
        return lvlAI;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getMoveAlgorithm() {
        return moveAlgorithm;
    }

    public Measurements getMeasurements() {
        return measurements;
    }
}
