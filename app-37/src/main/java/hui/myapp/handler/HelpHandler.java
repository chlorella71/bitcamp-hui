package hui.myapp.handler;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.util.AnsiEscape;
import hui.util.Prompt;

public class HelpHandler extends AbstractMenuHandler {

    public HelpHandler(Prompt prompt) {
        super(prompt);
    }

    @Override
    protected void action() {
        System.out.println("도움말입니다.");
    }
}
