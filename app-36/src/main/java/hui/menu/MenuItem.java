package hui.menu;

import hui.util.Prompt;
import java.util.Stack;

/*
Composite 패턴에서 leaf 역할을 수행하는 클래스
Leaf?
- 하위 항목을 포함하지 않는 말단 객체
- 예를들어 파일시스템에서 '파일'에 해당.
 */
public class MenuItem extends AbstractMenu{

    private MenuHandler menuHandler;

    public MenuItem(String title, Stack<String> breadcrumb) {
        super(title, breadcrumb);
    }

    public MenuItem(String title, Stack<String> breadcrumb, MenuHandler menuHandler) {
        this(title, breadcrumb);
        this.menuHandler = menuHandler;
    }
    
    @Override
    public void execute(Prompt prompt) {
        if (this.menuHandler != null) {
            try {
                this.menuHandler.action(this);
            } catch (Exception e) {
                System.out.println("실행 오류!");
            }
        }
    }

}
