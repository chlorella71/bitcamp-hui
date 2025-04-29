package hui;

import java.util.Scanner;

public class Main {

    // 애플리케이션 클래스 Main을 실행할 때 다음 변수를 미리 준비해둠
    static final String ANSI_CLEAR = "\033[0m";
    static final String ANSI_BOLD_RED = "\033[1;31m";
    static final String ANSI_RED = "\033[0;31m";
    static final String APP_TITLE = ANSI_BOLD_RED + "[과제관리 시스템]" + ANSI_CLEAR;
    static final String[] MENUS = {
            "1. 과제",
            "2. 게시글",
            "3. 도움말",
            ANSI_RED + "4. 종료" + ANSI_CLEAR
    };

    public static void main(String[] args) {

        printMainMenu();

        Scanner in = new Scanner(System.in);

        loop:
        while (true) {
            String input = prompt("메인", in);

            switch (input) {
                case "1":
                    onAssignment(in);
                    break;
                case "2":
                    onBoard(in);
                    break;
                case "3":
                    System.out.println("도움말입니다.");
                    break;
                case "4":
                    System.out.println("종료합니다.");
                    break loop;
                case "menu":
                    /*
                    코드를 기능단위로 묶어 메서드를 정의하면
                    메서드의 이름을 통해 해당 기능을 쉽게 유추할 수 있어 유지보수에 좋음.
                    */
                    printMainMenu();
                    break;
                default:
                    System.out.println("메뉴 번호가 옳지 않습니다.");
            }
        }

        in.close();
    }

    static void printMainMenu() {
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

    static String prompt(String title, Scanner in) {
        System.out.printf("%s> ", title);
        return in.nextLine();
    }

    static void onAssignment(Scanner in) {
        printAssignmentMenu();

        while (true) {
            String input = prompt("메인/과제", in);

            switch (input) {
                case "1":
                    System.out.println("등록입니다.");
                    break;
                case "2":
                    System.out.println("조회입니다.");
                    break;
                case "3":
                    System.out.println("변경입니다.");
                    break;
                case "4":
                    System.out.println("삭제입니다.");
                    break;
                case "0":
                    return;
                case "menu":
                    printAssignmentMenu();
                    break;
                default:
                    System.out.println("메뉴 번호가 옳지 않습니다.");
            }
        }
    }

    static void printAssignmentMenu() {
        System.out.println("[과제]");
        System.out.println("1. 등록");
        System.out.println("2. 조회");
        System.out.println("3. 변경");
        System.out.println("4. 삭제");
        System.out.println("0. 이전");
    }

    static void onBoard(Scanner in) {
        printBoardMenu();
        while (true) {
            String input = prompt("메인/게시글", in);

            switch (input) {
                case "1":
                    System.out.println("등록입니다.");
                    break;
                case "2":
                    System.out.println("조회입니다.");
                    break;
                case "3":
                    System.out.println("변경입니다.");
                    break;
                case "4":
                    System.out.println("삭제입니다.");
                    break;
                case "0":
                    return;
                case "menu":
                    printBoardMenu();
                    break;
                default:
                    System.out.println("메뉴 번호가 옳지 않습니다.");
            }
        }
    }

    static void printBoardMenu() {
        System.out.println("[게시글]");
        System.out.println("1. 등록");
        System.out.println("2. 조회");
        System.out.println("3. 변경");
        System.out.println("4. 삭제");
        System.out.println("0. 이전");
    }

}