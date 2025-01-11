package bitcamp.menu;

import bitcamp.util.Prompt;

public class MenuItem implements Menu{

    String title;
    MenuHandler menuHandler;

    public MenuItem(String title) {
        this.title= title;
    }

    public MenuItem(String title, MenuHandler menuHandler) {
        this(title);
        this.menuHandler = menuHandler;
    }

    @Override
    public void execute(Prompt prompt) {
        if (menuHandler != null) {
            menuHandler.action(this);
        }
    }

    @Override
    public String getTitle() {
        return title;
    }
}
