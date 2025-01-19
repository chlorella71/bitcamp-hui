package bitcamp.menu;

import bitcamp.util.Prompt;

public class MenuGroup implements Menu{

    private String title;
    private Menu[] menus = new Menu[10];
    private int menuSize;

    public MenuGroup(String title) {
        this.title = title;
    }

    @Override
    public void execute(Prompt prompt) {
        printMenu();

        while (true) {
            String input = prompt.input("%s> ", title);

            if (input.equals("menu")) {
                printMenu();
                continue;
            } else if (input.equals("0")) {
                break;
            }

            int menuNo = Integer.parseInt(input);
            if (menuNo < 1 || menuNo > this.menuSize) {
                System.out.println("메뉴 번호가 옳지 않습니다.");
                continue;
            }
            menus[menuNo -1].execute(prompt);
        }
    }

    private void printMenu() {
        System.out.printf("[%s]\n", title);

        for (int i = 0; i< menuSize; i++) {
            System.out.printf("%d. %s\n", (i+1), menus[i].getTitle());
        }

        System.out.printf("0. %s\n", "이전");
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void add(Menu menu) {
        if (menuSize == menus.length) {
            int oldSize = menus.length;
            int newSize = oldSize + (oldSize >> 1);

            Menu[] arr = new Menu[newSize];
            for (int i= 0; i < oldSize; i++) {
                arr[i] = menus[i];
            }

            menus = arr;
        }
        menus[menuSize++]=menu;
    }

    public void remove(Menu menu) {
        int index = indexOf(menu);
        if (index == -1) {
            return;
        }

        for (int i = index; i< (menuSize-1); i++) {
            menus[i] = menus[i+1];
        }
        menus[--menuSize] = null;
    }

    int indexOf(Menu menu) {
        for (int i = 0; i< menuSize; i++) {
            if (menu == menus[i]) {
                return i;
            }
        }
        return -1;
    }
}
