public class Main {
    public static void main(String[] args) {
        Player player1 = new Player(1,true,0,0);
        Player player2 = new Player(2,true,0,0);
        Board board = new Board(6);
        board.initialiseBoard(4);
        Game game = new Game(board,player1, player2);
        game.gameplay();
    }
}