package hui.menu;

import hui.util.AnsiEscape;
import hui.util.Prompt;

public abstract class AbstractMenuHandler implements MenuHandler{

    protected Prompt prompt;
    protected Menu menu;

    public AbstractMenuHandler(Prompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        this.printMenuTitle(menu.getTitle());
        this.menu = menu;   // 서브 클래스를 구현할 때 사용할 일이 있다면 볼 수 있도록 보관해둔다.

        /*
        Menu를 실행할 때 이 메서드가 호출되면
        즉시 서브 클래스의 다음 메서드를 호출함.
         */
        this.action();
    }

    private void printMenuTitle(String title) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, title);
    }

    /*
    서브 클래스가 구현해야 할 메서드임.
    수퍼 클래스의 action(Menu)을 실행할 때 호출되는 메서드임.
    외부에서 호출할 메서드가 아님.
    따라서 접근 범위를 서브 클래스에서 접근할 수 있도록 제한함.
     */
    protected abstract void action();
}
