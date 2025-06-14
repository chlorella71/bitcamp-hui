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
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import java.io.*;
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

        try (FileInputStream in0 = new FileInputStream("assignment.data");
            BufferedInputStream in1 = new BufferedInputStream(in0);
            java.io.DataInputStream in = new java.io.DataInputStream(in1);) {

            long start = System.currentTimeMillis();

            int size = in.readInt();

            for (int i = 0; i < size; i++) {
                Assignment assignment = new Assignment();
                assignment.setTitle(in.readUTF());
                assignment.setContent(in.readUTF());
                assignment.setDeadline(Date.valueOf(in.readUTF()));

                assignmentRepository.add(assignment);
            }

            long end = System.currentTimeMillis();
            System.out.printf("걸린 시간: %d\n", end - start);

        } catch (Exception e) {
            System.out.println("과제 데이터 로딩 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void saveAssignment() {
        try (FileOutputStream out0 = new FileOutputStream("assignment.data");
             BufferedOutputStream out1 = new BufferedOutputStream(out0);
             DataOutputStream out = new DataOutputStream(out1)) {

            long start = System.currentTimeMillis();

            out.writeInt(assignmentRepository.size());

            for (Assignment assignment : assignmentRepository) {
                out.writeUTF(assignment.getTitle());
                out.writeUTF(assignment.getContent());
                out.writeUTF(assignment.getDeadline().toString());
            }

            long end = System.currentTimeMillis();
            System.out.printf("걸린 시간: %d\n", end - start);

        } catch (Exception e) {
            System.out.println("과제 데이터 저장 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void loadMember() {
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("member.data")))) {
            int size = in.readShort();

            for (int i = 0; i < size; i++) {
                Member member = new Member();

                member.setName(in.readUTF());
                member.setEmail(in.readUTF());
                member.setPassword(in.readUTF());
                member.setCreatedDate(new java.util.Date(in.readLong()));

                memberRepository.add(member);
            }
        } catch (Exception e) {
            System.out.println("회원 데이터 로딩 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void saveMember() {
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("member.data")))) {

            out.writeShort(memberRepository.size());

            for (Member member : memberRepository) {
                out.writeUTF(member.getName());
                out.writeUTF(member.getEmail());
                out.writeUTF(member.getPassword());
                out.writeLong(member.getCreatedDate().getTime());
            }
        } catch (Exception e) {
            System.out.println("회원 데이터 저장 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void loadBoard() {
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("board.data")))) {
            int size = in.readShort();

            for (int i = 0; i < size; i++) {
                Board board = new Board();

                board.setTitle(in.readUTF());
                board.setContent(in.readUTF());
                board.setWriter(in.readUTF());
                board.setCreatedDate(new java.util.Date(in.readLong()));

                boardRepository.add(board);
            }
        } catch (Exception e) {
            System.out.println("게시글 데이터 로딩 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void saveBoard() {
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("board.data")))) {

            out.writeShort(boardRepository.size());

            for (Board board : boardRepository) {
                out.writeUTF(board.getTitle());
                out.writeUTF(board.getContent());
                out.writeUTF(board.getWriter());
                out.writeLong(board.getCreatedDate().getTime());
            }
        } catch (Exception e) {
            System.out.println("게시글 데이터 저장 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void loadGreeting() {
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("greeting.data")))) {
            int size = in.readShort();

            for (int i = 0; i < size; i++) {
                Board board = new Board();

                board.setTitle(in.readUTF());
                board.setContent(in.readUTF());
                board.setWriter(in.readUTF());
                board.setCreatedDate(new java.util.Date(in.readLong()));

                greetingRepository.add(board);
            }
        } catch (Exception e) {
            System.out.println("가입인사 데이터 로딩 중 오류 발생!");
            e.printStackTrace();
        }
    }

    void saveGreeting() {
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("greeting.data")))) {

            out.writeShort(greetingRepository.size());

            for (Board board : greetingRepository) {
                out.writeUTF(board.getTitle());
                out.writeUTF(board.getContent());
                out.writeUTF(board.getWriter());
                out.writeLong(board.getCreatedDate().getTime());
            }
        } catch (Exception e) {
            System.out.println("가입인사 데이터 저장 중 오류 발생!");
            e.printStackTrace();
        }
    }
}