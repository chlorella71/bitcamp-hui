package hui;

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
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import hui.util.Prompt;
//import java.util.ArrayList;

public class Main {

    Prompt prompt = new Prompt(System.in);

    List<Board> boardRepository = new LinkedList<>();
    List<Assignment> assignmentRepository = new LinkedList<>();
    List<Member> memberRepository = new ArrayList<>();
    List<Board> greetingRepository = new ArrayList<>();

    MenuGroup mainMenu;

    Main() {
        prepareMenu();
        loadAssignment();
        loadMember();
        loadBoard();
        loadGreeting();
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

        saveAssignment();
        saveMember();
        saveBoard();
        saveGreeting();
    }

    void loadAssignment() {

        try (FileInputStream in = new FileInputStream("assignment.data")) {
            byte[] bytes = new byte[60000];
            int size = in.read() << 8 | in.read();

            for (int i = 0; i < size; i++) {
                int len = in.read() << 8 | in.read();
                in.read(bytes, 0, len);
                String title = new String(bytes, 0, len, StandardCharsets.UTF_8);

                len = in.read() << 8 | in.read();
                in.read(bytes, 0, len);
                String content = new String(bytes, 0, len, StandardCharsets.UTF_8);

                in.read(bytes, 0, 10);
                Date deadline = Date.valueOf(new String(bytes, 0, 10, StandardCharsets.UTF_8));

                Assignment assignment = new Assignment();
                assignment.setTitle(title);
                assignment.setContent(content);
                assignment.setDeadline(deadline);

                assignmentRepository.add(assignment);
            }
        } catch (Exception e) {
            System.out.println("과제 데이터 로딩 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void saveAssignment() {
        try (FileOutputStream out = new FileOutputStream("assignment.data")) {

            // 저장할 개수를 2바이트로 출력함.
            out.write(assignmentRepository.size() >> 8);
            out.write(assignmentRepository.size());

            for (Assignment assignment : assignmentRepository) {
                // assignment 객체에서 값을 꺼내 바이트 배열로 만든 다음에 출력함.
                String title = assignment.getTitle();
                byte[] bytes = title.getBytes(StandardCharsets.UTF_8);
                // 바이트의 개수를 2바이트로 출력함.
                out.write(bytes.length >> 8);
                out.write(bytes.length);
                // 문자열의 바이트 배열을 출력함.
                out.write(bytes);

                String content = assignment.getContent();
                bytes = content.getBytes(StandardCharsets.UTF_8);
                out.write(bytes.length >> 8);
                out.write(bytes.length);
                out.write(bytes);

                String deadline = assignment.getDeadline().toString();
                bytes = deadline.getBytes(StandardCharsets.UTF_8);
                out.write(bytes);
            }
        } catch (Exception e) {
            System.out.println("과제 데이터 저장 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void loadMember() {
        try (FileInputStream in = new FileInputStream("member.data")) {
            byte[] bytes = new byte[60000];
            int size = in.read() << 8 | in.read();

            for (int i = 0; i < size; i++) {
                Member member = new Member();

                int len = in.read() << 8 | in.read();
                in.read(bytes, 0, len);
                member.setName(new String(bytes, 0, len, StandardCharsets.UTF_8));

                len = in.read() << 8 | in.read();
                in.read(bytes, 0, len);
                member.setEmail(new String(bytes, 0, len, StandardCharsets.UTF_8));

                long date = ((long) in.read() << 56) |
                        ((long) in.read() << 42) |
                        ((long) in.read() << 40) |
                        ((long) in.read() << 32) |
                        ((long) in.read() << 24) |
                        ((long) in.read() << 16) |
                        ((long) in.read() << 8) |
                        in.read();
                member.setCreatedDate(new java.util.Date(date));

                memberRepository.add(member);
            }
        } catch (Exception e) {
            System.out.println("회원 데이터 로딩 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void saveMember() {
        try (FileOutputStream out = new FileOutputStream("member.data")) {

            out.write(memberRepository.size() >> 8);
            out.write(memberRepository.size());

            for (Member member : memberRepository) {
                byte[] bytes = member.getName().getBytes(StandardCharsets.UTF_8);
                out.write(bytes.length >> 8);
                out.write(bytes.length);
                out.write(bytes);

                bytes = member.getEmail().getBytes(StandardCharsets.UTF_8);
                out.write(bytes.length >> 8);
                out.write(bytes.length);
                out.write(bytes);

                bytes = member.getPassword().getBytes(StandardCharsets.UTF_8);
                out.write(bytes.length >> 8);
                out.write(bytes.length);
                out.write(bytes);

                long date = member.getCreatedDate().getTime();
                out.write((int) (date >> 56));
                out.write((int) (date >> 48));
                out.write((int) (date >> 40));
                out.write((int) (date >> 32));
                out.write((int) (date >> 24));
                out.write((int) (date >> 16));
                out.write((int) (date >> 8));
                out.write((int) date);
            }
        } catch (Exception e) {
            System.out.println("회원 데이터 저장 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void loadBoard() {
        try (FileInputStream in = new FileInputStream("board.data")) {
            byte[] bytes = new byte[60000];
            int size = in.read() << 8 | in.read();

            for (int i = 0; i < size; i++) {
                Board board = new Board();

                int len = in.read() << 8 | in.read();
                in.read(bytes, 0, len);
                board.setTitle(new String(bytes, 0, len, StandardCharsets.UTF_8));

                len = in.read() << 8 | in.read();
                in.read(bytes, 0, len);
                board.setContent(new String(bytes, 0, len, StandardCharsets.UTF_8));

                len = in.read() << 8 | in.read();
                in.read(bytes, 0, len);
                board.setWriter(new String(bytes, 0, len, StandardCharsets.UTF_8));

                long date = ((long) in.read() << 56) |
                        ((long) in.read() << 42) |
                        ((long) in.read() << 40) |
                        ((long) in.read() << 32) |
                        ((long) in.read() << 24) |
                        ((long) in.read() << 16) |
                        ((long) in.read() << 8) |
                        in.read();
                board.setCreatedDate(new java.util.Date(date));

                boardRepository.add(board);
            }
        } catch (Exception e) {
            System.out.println("게시글 데이터 로딩 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void saveBoard() {
        try (FileOutputStream out = new FileOutputStream("board.data")) {

            out.write(boardRepository.size() >> 8);
            out.write(boardRepository.size());

            for (Board board : boardRepository) {
                byte[] bytes = board.getTitle().getBytes(StandardCharsets.UTF_8);
                out.write(bytes.length >> 8);
                out.write(bytes.length);
                out.write(bytes);

                bytes = board.getWriter().getBytes(StandardCharsets.UTF_8);
                out.write(bytes.length >> 8);
                out.write(bytes.length);
                out.write(bytes);

                long date = board.getCreatedDate().getTime();
                out.write((int) (date >> 56));
                out.write((int) (date >> 48));
                out.write((int) (date >> 40));
                out.write((int) (date >> 32));
                out.write((int) (date >> 24));
                out.write((int) (date >> 16));
                out.write((int) (date >> 8));
                out.write((int) date);
            }
        } catch (Exception e) {
            System.out.println("게시글 데이터 저장 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void loadGreeting() {
        try (FileInputStream in = new FileInputStream("greeting.data")) {
            byte[] bytes = new byte[60000];
            int size = in.read() << 8 | in.read();

            for (int i = 0; i < size; i++) {
                Board board = new Board();

                int len = in.read() << 8 | in.read();
                in.read(bytes, 0, len);
                board.setTitle(new String(bytes, 0, len, StandardCharsets.UTF_8));

                len = in.read() << 8 | in.read();
                in.read(bytes, 0, len);
                board.setContent(new String(bytes, 0, len, StandardCharsets.UTF_8));

                len = in.read() << 8 | in.read();
                in.read(bytes, 0, len);
                board.setWriter(new String(bytes, 0, len, StandardCharsets.UTF_8));

                long date = ((long) in.read() << 56) |
                        ((long) in.read() << 42) |
                        ((long) in.read() << 40) |
                        ((long) in.read() << 32) |
                        ((long) in.read() << 24) |
                        ((long) in.read() << 16) |
                        ((long) in.read() << 8) |
                        in.read();
                board.setCreatedDate(new java.util.Date(date));

                greetingRepository.add(board);
            }
        } catch (Exception e) {
            System.out.println("가입인사 데이터 로딩 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void saveGreeting() {
        try (FileOutputStream out = new FileOutputStream("greeting.data")) {

            out.write(greetingRepository.size() >> 8);
            out.write(greetingRepository.size());

            for (Board board : greetingRepository) {
                byte[] bytes = board.getTitle().getBytes(StandardCharsets.UTF_8);
                out.write(bytes.length >> 8);
                out.write(bytes.length);
                out.write(bytes);

                bytes = board.getContent().getBytes(StandardCharsets.UTF_8);
                out.write(bytes.length >> 8);
                out.write(bytes.length);
                out.write(bytes);

                bytes = board.getWriter().getBytes(StandardCharsets.UTF_8);
                out.write(bytes.length >> 8);
                out.write(bytes.length);
                out.write(bytes);

                long date = board.getCreatedDate().getTime();
                out.write((int) (date >> 56));
                out.write((int) (date >> 48));
                out.write((int) (date >> 40));
                out.write((int) (date >> 32));
                out.write((int) (date >> 24));
                out.write((int) (date >> 16));
                out.write((int) (date >> 8));
                out.write((int) date);
            }
        } catch (Exception e) {
            System.out.println("가입인사 데이터 저장 중 오류 발생!");
            e.printStackTrace();
        }
    }
}