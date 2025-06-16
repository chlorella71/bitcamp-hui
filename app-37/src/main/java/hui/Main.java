package hui;

import hui.io.BufferedDataInputStream;
import hui.io.BufferedDataOutputStream;
import hui.menu.Menu;
import hui.menu.MenuGroup;
import hui.menu.MenuItem;
import hui.myapp.handler.HelpHandler;
//import hui.myapp.handler.MainMenu;
import hui.myapp.handler.assignment.*;
import hui.myapp.handler.board.*;
import hui.myapp.handler.member.*;
import hui.myapp.vo.Assignment;
import hui.myapp.vo.Board;
import hui.myapp.vo.CsvString;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.*;

import hui.util.Prompt;
//import java.util.ArrayList;

public class Main {

    Prompt prompt = new Prompt(System.in);

    List<Board> boardRepository = new ArrayList<>();
    List<Assignment> assignmentRepository = new LinkedList<>();
    List<Member> memberRepository = new ArrayList<>();
    List<Board> greetingRepository = new LinkedList<>();

    MenuGroup mainMenu;

    Main() {
        /*
        loadData("assignment.data", assignmentRepository);
        loadData("member.data", memberRepository);
        loadData("board.data", boardRepository);
        loadData("greeting.data", greetingRepository);

         */
        assignmentRepository = loadData("assignment.csv", Assignment.class);
        memberRepository = loadData("member.csv", Member.class);
        boardRepository = loadData("board.csv", Board.class);
        greetingRepository =  loadData("greeting.csv", Board.class);
        prepareMenu();
    }

    public static void main(String[] args) throws Exception {

        File dir = new File(".");
        System.out.println("실행 디렉토리 (working directory):");
        System.out.println(dir.getAbsoluteFile());

        new Main().run();
    }

    void prepareMenu() {

        System.out.println(AnsiEscape.ANSI_BOLD_RED + "[과제관리 시스템]" + AnsiEscape.ANSI_CLEAR);
        System.out.println();

        mainMenu = MenuGroup.getInstance("메인");

        MenuGroup assignmentMenu = mainMenu.addGroup("과제");
        assignmentMenu.addItem("등록", new AssignmentAddHandler(assignmentRepository, prompt));
        assignmentMenu.addItem("조회", new AssignmentViewHandler(assignmentRepository, prompt));
        assignmentMenu.addItem("변경", new AssignmentModifyHandler(assignmentRepository, prompt));
        assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt));
        assignmentMenu.addItem("목록", new AssignmentListHandler(assignmentRepository, prompt));

        MenuGroup boardMenu = mainMenu.addGroup("게시글");
        boardMenu.addItem("등록", new BoardAddHandler(boardRepository, prompt));
        boardMenu.addItem("조회", new BoardViewHandler(boardRepository, prompt));
        boardMenu.addItem("변경", new BoardModifyHandler(boardRepository, prompt));
        boardMenu.addItem("삭제", new BoardDeleteHandler(boardRepository, prompt));
        boardMenu.addItem("목록", new BoardListHandler(boardRepository, prompt));

        MenuGroup memberMenu = mainMenu.addGroup("회원");
        memberMenu.addItem("등록", new MemberAddHandler(memberRepository, prompt));
        memberMenu.addItem("조회", new MemberViewHandler(memberRepository, prompt));
        memberMenu.addItem("변경", new MemberModifyHandler(memberRepository, prompt));
        memberMenu.addItem("삭제", new MemberDeleteHandler(memberRepository, prompt));
        memberMenu.addItem("목록", new MemberListHandler(memberRepository, prompt));

        MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
        greetingMenu.addItem("등록", new BoardAddHandler(greetingRepository, prompt));
        greetingMenu.addItem("조회", new BoardViewHandler(greetingRepository, prompt));
        greetingMenu.addItem("변경", new BoardModifyHandler(greetingRepository, prompt));
        greetingMenu.addItem("삭제", new BoardDeleteHandler(greetingRepository, prompt));
        greetingMenu.addItem("목록", new BoardListHandler(greetingRepository, prompt));

        mainMenu.addItem("도움말", new HelpHandler(prompt));
    }

    void run() {
        /*
        프로그램을 실행하다가 어느 시점에서 예외가 발생하면 해당 위치에서 적절한 조치를 취할 것임.
        다만 그에 벗어나서 조치가 되지 않은 예외가 보고되는 경우를 대비해
        마지막 보루인 main()에서는 예외를 처리해야 함.
        main()에서 마저 처리하지 않는다면 jvm에게 보고될 것이고,
        jvm은 개발자나 알아 볼 메세지를 출력하고 종료할 것임.
         */
        while (true) {
            try {
                mainMenu.execute(prompt);
                prompt.close();
                break;
            } catch(Exception e){
                System.out.println("예외 발생!");
            }
        }

        saveData("assignment.csv", assignmentRepository);
        saveData("member.csv", memberRepository);
        saveData("board.csv", boardRepository);
        saveData("greeting.csv", greetingRepository);
    }

    /*
    <E> void loadData(String filepath, List<E> dataList) {
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(filepath)))) {

            List<E> list = (List<E>) in.readObject();
            dataList.addAll(list);

        } catch (Exception e) {
            System.out.printf("%s 파일 로딩 중 오류 발생!\n", filepath);
            e.printStackTrace();
        }
    }

     */

    <E> List<E> loadData(String filepath, Class<E> clazz) {

        // 0) 객체를 저장할 List를 준비함.
        ArrayList<E> list = new ArrayList<>();

        try (Scanner in = new Scanner(new FileReader(filepath))) {
            // 1) 클래스 정보를 가지고 팩토리 메서드를 알아냄.
            Method factoryMethod = clazz.getMethod("createFromCsv", String.class);

            while (true) {
                // 2) 팩토리 메서드에 CSV 문자열을 전달하고 객체를 리턴 받음.
                E obj = (E) factoryMethod.invoke(null, in.nextLine());

                // 3) 생성한 객체를 List에 저장함.
                list.add(obj);
            }
        } catch (NoSuchElementException e) {
            System.out.printf("%s 파일 로딩 완료!\n", filepath);

        } catch (Exception e) {
            System.out.printf("%s 파일 로딩 중 오류 발생!\n", filepath);
            e.printStackTrace();
        }
        return list;
    }

    void saveData(String filepath, List<? extends CsvString> dataList) {

        try (FileWriter out = new FileWriter(filepath)) {

            for (CsvString csvObject : dataList) {
                out.write(csvObject.toCsvString() + "\n");
            }
        } catch (Exception e) {
            System.out.printf("%s 파일 저장 중 오류 발생!\n", filepath);
            e.printStackTrace();
        }
    }
}