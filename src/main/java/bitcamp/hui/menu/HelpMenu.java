package bitcamp.hui.menu;

import bitcamp.hui.util.Prompt;

public class HelpMenu implements Menu{
    String title;
    Prompt prompt;

    public HelpMenu(String title, Prompt prompt) {
        this.title = title;
        this.prompt = prompt;
    }

    public void execute() {
        System.out.printf("[%s]\n", this.title);
        System.out.println("도움말입니다.");
    }
}
