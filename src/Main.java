import controller.Connect;
import dao.MainMenu;

public class Main {
    public static void main(String[] args) {
        Connect connect = new Connect();
        MainMenu mainMenu = new MainMenu();
        mainMenu.start();

    }
}
