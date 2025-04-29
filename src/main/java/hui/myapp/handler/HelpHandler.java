package hui.myapp.handler;

import hui.menu.AbstractMenuHandler;
import hui.util.AnsiEscape;
import hui.util.Prompt;

public class HelpHandler extends AbstractMenuHandler {

    public HelpHandler(Prompt prompt) {
        super(prompt);
    }

    @Override
    public void action() {
        System.out.printf(AnsiEscape.ANSI_BOLD +"[%s]\n"+ AnsiEscape.ANSI_CLEAR, menu.getTitle());

        System.out.println("도움말입니다.");
    }
}
