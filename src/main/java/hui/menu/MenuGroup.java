package hui.menu;

import hui.util.Prompt;

import hui.util.LinkedList;
import hui.util.List;

// Composite 패턴에서 '복합 객체(composite object)' 역할을 하는 클래스
// - 다른 Menu 객체를 포함
public class MenuGroup extends AbstractMenu{

    private List<Menu> menus = new LinkedList<>();

    public MenuGroup(String title) {
        super(title);
    }

    @Override   // 인터페이스나 수퍼클래스의 메서드를 정의하겠다고 컴파일러에게 알림
    public void execute(Prompt prompt) {
        printMenu();

        while (true) {
            String input = prompt.input("%s> ", this.getTitle());

            if (input.equals("menu")) {
                printMenu();
                continue;
            } else if (input.equals("0")) {
                break;
            }

            int menuNo = Integer.parseInt(input);
            if (menuNo < 1 || menuNo > this.menus.size()) {
                System.out.println("메뉴 번호가 옳지 않습니다.");
                continue;
            }
            menus.get(menuNo -1).execute(prompt);
        }
    }

    private void printMenu() {
        System.out.printf("[%s]\n", this.getTitle());

        for (int i = 0; i< menus.size(); i++) {
            System.out.printf("%d. %s\n", (i+1), menus.get(i).getTitle());
        }

        System.out.printf("0. %s\n", "이전");
    }

    public void add(Menu menu) {
        menus.add(menu);
    }

    public void remove(Menu menu) {
        menus.remove(menu);
    }
}
