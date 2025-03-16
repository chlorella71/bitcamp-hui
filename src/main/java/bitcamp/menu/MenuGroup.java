package bitcamp.menu;

import bitcamp.util.Prompt;

import java.util.LinkedList;
import java.util.List;

public class MenuGroup extends AbstractMenu{

    private List<Menu> menus = new LinkedList<>();

    public MenuGroup(String title) {
        super(title);
    }

    @Override
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
