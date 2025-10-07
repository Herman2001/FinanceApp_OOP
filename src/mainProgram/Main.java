package mainProgram;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        AppSetup setup = new AppSetup();
        MenuHandler menu = new MenuHandler(setup.getCommands(), setup.getInput());
        menu.run();
    }
}