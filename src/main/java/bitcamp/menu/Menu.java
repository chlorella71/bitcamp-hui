package bitcamp.menu;

import bitcamp.util.Prompt;

public interface Menu {
    public abstract void execute(Prompt prompt);

    public abstract String getTitle();
}
