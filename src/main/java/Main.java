import Modele.GameConsole;
import Modele.Wizard;

public class Main {
    public static void main(String[] args) {
        GameConsole gameConsole = new GameConsole();
        Wizard player = gameConsole.startOfGame();
        gameConsole.level();
    }
}