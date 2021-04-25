public class Main {
    public static void main(String[] args) {
        Board board = new Board(6);
        board.initialiseBoard(4);
        new GUIBoard(board);
    }
}