public class Measurements {
    long timeMillis;
    int moveCount;
    long startTimer;

    public Measurements() {
        timeMillis = 0;
        moveCount = 0;
        startTimer = 0;
    }

    public void clear() {
        timeMillis = 0;
        moveCount = 0;
        startTimer = 0;
    }

    public void startTimer() {
        startTimer = System.currentTimeMillis();
    }

    public void stopTimer() {
        timeMillis += (System.currentTimeMillis() - startTimer);
        startTimer = 0;
    }

    public void plusCount() {
        moveCount += 1;
    }

    public void displayMeasurements() {
        System.out.println("Time: " + timeMillis + " , moves: " + moveCount);
    }
}
