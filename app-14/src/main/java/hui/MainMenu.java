package hui;

import java.util.Scanner;

public class MainMenu {

    // 클래스가 호출될 때 다음 변수를 미리 준비해둠
    static final String ANSI_CLEAR = "\033[0m";
    static final String ANSI_BOLD_RED = "\033[1;31m";
    static final String ANSI_RED = "\033[0;31m";
    static final String APP_TITLE = ANSI_BOLD_RED + "[과제관리 시스템]" + ANSI_CLEAR;
    static final String[] MENUS = {
            "1. 과제",
            "2. 게시글",
            "3. 회원",
            "4. 가입인사",
            "5. 도움말",
            ANSI_RED + "0. 종료" + ANSI_CLEAR
    };

    static void printMenu() {
        /*
        ASNI 코드와 App 제목, 메뉴를 저장한 변수를 메서드 안에 두는 대신에
        클래스 블록 안에 두면
        printMenu()를 호출할 때 마다 변수를 만들기 않기 때문에 실행 속도나 메모리 부분에서
        훨씬 효율적임.
        보통 메서드 호출될 때 마다 값이 바뀌는 변수가 아니라 고정 값을 갖는 변수인 경우
        메서드 밖에 두는 것이 좋음.
        */
        System.out.println(APP_TITLE);
        System.out.println();
        for (String menu : MENUS) {
            System.out.println(menu);
        }
    }

    static void execute() {
        printMenu();

        while (true) {
            String input = Prompt.input("메인> ");

            switch (input) {
                case "1":
                    AssignmentMenu.execute();
                    break;
                case "2":
                    BoardMenu.execute();
                    break;
                case "3":
                    MemberMenu.execute();
                    break;
                case "4":
                    GreetingBoardMenu.execute();
                    break;
                case "5":
                    System.out.println("도움말입니다.");
                    break;
                case "0":
                    System.out.println("종료합니다.");
                    return;
                case "menu":
                    /*
                    코드를 기능단위로 묶어 메서드를 정의하면
                    메서드의 이름을 통해 해당 기능을 쉽게 유추할 수 있어 유지보수에 좋음.
                    */
                    printMenu();
                    break;
                default:
                    System.out.println("메뉴 번호가 옳지 않습니다.");
            }
        }
    }
}
