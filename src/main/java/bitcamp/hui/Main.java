package bitcamp.hui;

import bitcamp.hui.menu.MainMenu;
import bitcamp.hui.util.Prompt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.in);
        new MainMenu(prompt).execute();
        prompt.close();
    }
}