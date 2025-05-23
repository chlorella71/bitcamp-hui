package hui.menu;

import hui.util.AnsiEscape;
import hui.util.Prompt;
import hui.util.List;
import hui.util.LinkedList;
import hui.util.Stack;

/*
Composite 패턴에서 '복합 객체(composite object)' 역할을 하는 클래스
- 다른 Menu 객체를 포함함.
 */
public class MenuGroup extends AbstractMenu{

//    String title;
    /*
    private Menu[] menus = new Menu[10];
    private int menuSize;
     */
    private List<Menu> menus = new LinkedList<>();

    public MenuGroup(String title, Stack<String> breadcrumb) {
        super(title, breadcrumb);
    }

    // GoF의 Factory Method 디자인패턴!
    public static MenuGroup getInstance(String title) {
        return new MenuGroup(title, new Stack<String>());
    }

    @Override   // 인터페이스나 수퍼클래스의 메서드를 정의하겠다고 컴파일러에게 알림.
    public void execute(Prompt prompt) {

        // 메뉴를 실행할 때 메뉴의 제목을 breadcrumb 경로에 추가함.
        breadcrumb.push(this.title);

        this.printMenu();

        while(true) {
            String input = prompt.input("%s> ", this.getMenuPath());

            if (input.equals("menu")) {
                this.printMenu();
                continue;
            } else if (input. equals("0")) {
                break;
            }

            try {
                int menuNo = Integer.parseInt(input);
                if (menuNo < 1 || menuNo > menus.size()) {
                    System.out.println("메뉴 번호가 올바르지 않습니다.");
                    continue;
                }

                this.menus.get(menuNo - 1).execute(prompt);
            } catch (Exception e) {
                System.out.println("메뉴가 옳지 않습니다!");
            }
        }

        // 메뉴를 나갈 때 breadcrumb 메뉴 경로에서 메뉴 제목을 제거함.
        breadcrumb.pop();
    }

    private void printMenu() {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, getTitle());

        for (int i = 0; i < this.menus.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), menus.get(i).getTitle());
        }

        System.out.printf("0. %s\n", "이전");
    }

    public void add(Menu menu) {
        this.menus.add(menu);
    }

    public MenuItem addItem(String title, MenuHandler handler) {
        MenuItem menuItem = new MenuItem(title, this.breadcrumb, handler);
        this.add(menuItem);
        return menuItem;
    }

    public MenuGroup addGroup(String title) {
        MenuGroup menuGroup = new MenuGroup(title, this.breadcrumb);
        this.add(menuGroup);
        return menuGroup;
    }

    public void remove(Menu menu) {
        this.menus.remove(menu);
    }
}
