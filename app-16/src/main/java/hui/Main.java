package hui;

import hui.myapp.handler.MainMenu;
import hui.util.Prompt;

public class Main {
    public static void main(String[] args) {

        Prompt prompt = new Prompt(System.in);
        new MainMenu(prompt).execute();
        prompt.close();
    }
}