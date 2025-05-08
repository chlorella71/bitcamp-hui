package hui.myapp.handler;

import hui.util.Prompt;

public class HelpMenu implements Menu{

    String title;
    Prompt prompt;

    public HelpMenu(String title, Prompt prompt) {
        this.title = title;
        this.prompt = prompt;
    }

    public void execute() {
        System.out.printf("[%s]\n", title);
        System.out.println("도움말입니다.");
    }
}
