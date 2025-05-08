//package hui.myapp.handler;
//
//import hui.menu.Menu;
//import hui.myapp.handler.assignment.AssignmentMenu;
//import hui.myapp.handler.board.BoardMenu;
//import hui.myapp.handler.member.MemberMenu;
//import hui.util.Prompt;
//import hui.util.AnsiEscape;
//
//public class MainMenu implements Menu {
//
//    static final String APP_TITLE = AnsiEscape.ANSI_BOLD_RED + "[과제관리 시스템]" + AnsiEscape.ANSI_CLEAR;
//    static final String[] MENUS = {
//            "1. 과제",
//            "2. 게시글",
//            "3. 회원",
//            "4. 가입인사",
//            "5. 도움말",
//            AnsiEscape.ANSI_RED + "0. 종료" + AnsiEscape.ANSI_CLEAR
//    };
//
//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;
//
//    public MainMenu(Prompt prompt) {
//        this.prompt = prompt;
//    }
//
//    static void printMenu() {
//        /*
//        ASNI 코드와 App 제목, 메뉴를 저장한 변수를 메서드 안에 두는 대신에
//        클래스 블록 안에 두면
//        printMenu()를 호출할 때 마다 변수를 만들기 않기 때문에 실행 속도나 메모리 부분에서
//        훨씬 효율적임.
//        보통 메서드 호출될 때 마다 값이 바뀌는 변수가 아니라 고정 값을 갖는 변수인 경우
//        메서드 밖에 두는 것이 좋음.
//        */
//        System.out.println(APP_TITLE);
//        System.out.println();
//        for (String menu : MENUS) {
//            System.out.println(menu);
//        }
//    }
//
//    public void execute() {
//
//        Menu boardMenu = new BoardMenu("게시판", this.prompt);
//        Menu greetingMenu = new BoardMenu("가입인사", this.prompt);
//        Menu assignmentMenu = new AssignmentMenu("과제", this.prompt);
//        Menu memberMenu = new MemberMenu("회원", this.prompt);
//        Menu helpMenu = new HelpHandler("도움말", this.prompt);
//
//
//        printMenu();
//
//        while (true) {
//            String input = prompt.input("메인> ");
//
//            switch (input) {
//                case "1":
//                    assignmentMenu.execute();
//                    break;
//                case "2":
//                    boardMenu.execute();
//                    break;
//                case "3":
//                    memberMenu.execute();
//                    break;
//                case "4":
//                    greetingMenu.execute();
//                    break;
//                case "5":
//                    helpMenu.execute();
//                    break;
//                case "0":
//                    System.out.println("종료합니다.");
//                    return;
//                case "menu":
//                    /*
//                    코드를 기능단위로 묶어 메서드를 정의하면
//                    메서드의 이름을 통해 해당 기능을 쉽게 유추할 수 있어 유지보수에 좋음.
//                    */
//                    printMenu();
//                    break;
//                default:
//                    System.out.println("메뉴 번호가 옳지 않습니다.");
//            }
//        }
//    }
//}
