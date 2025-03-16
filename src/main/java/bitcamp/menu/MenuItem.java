package bitcamp.menu;

import bitcamp.util.Prompt;

public class MenuItem extends AbstractMenu{

    private MenuHandler menuHandler;

    public MenuItem(String title) {
        super(title);
    }

    public MenuItem(String title, MenuHandler menuHandler) {
        this(title);
        this.menuHandler = menuHandler;
    }

    public void execute(Prompt prompt) {
        if (menuHandler != null) {
            try {
                menuHandler.action(this);
            } catch (Exception e) {
                System.out.println("실행 오류!");
            }
        }
    }
}
