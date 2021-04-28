public class Main {
    public static void main(String[] args) {
        GUIBoard gui = null;
        do {
            //tworzenie gui
            gui = new GUIBoard();

            //wyswietlanie ekranu startowego
            gui.gameStartScreen();

            //czekanie na play
            synchronized (gui) {
                try {
                    gui.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (gui.exitGame) {
                break;
            }
            // play wcisniete, mozna rozpoczac gre
            Game game = gui.game;

            //wyswietlanie ekranu gry
            gui.makeBoard(game.getBoard());

            //start gry
            game.gameplay(gui);

            //gra zakończona
            gui.gameFinishScreen(game.getBoard());

            synchronized (gui) {
                try {
                    gui.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //powrót do ekranu startowego
        } while (gui.replay);
    }
}