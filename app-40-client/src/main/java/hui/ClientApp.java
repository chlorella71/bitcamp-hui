package hui;

import hui.menu.MenuGroup;
import hui.myapp.dao.AssignmentDao;
import hui.myapp.dao.BoardDao;
import hui.myapp.dao.MemberDao;
import hui.myapp.dao.network.AssignmentDaoImpl;
import hui.myapp.dao.network.BoardDaoImpl;
import hui.myapp.dao.network.MemberDaoImpl;
import hui.myapp.handler.HelpHandler;
//import hui.myapp.handler.MainMenu;
import hui.myapp.handler.assignment.*;
import hui.myapp.handler.board.*;
import hui.myapp.handler.member.*;
//import hui.util.ObjectRepository;
import java.io.*;
import java.net.Socket;

import hui.util.Prompt;

import static hui.util.AnsiEscape.ANSI_BOLD_RED;
import static hui.util.AnsiEscape.ANSI_CLEAR;
//import java.util.ArrayList;

public class ClientApp {

    Prompt prompt = new Prompt(System.in);

    BoardDao boardDao;
    AssignmentDao assignmentDao;
    MemberDao memberDao;
    BoardDao greetingDao;

    MenuGroup mainMenu;

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    ClientApp() {
        prepareNetwork();
        prepareMenu();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(ANSI_BOLD_RED +  "[과제관리 시스템]" + ANSI_CLEAR);
        new ClientApp().run();
    }

    void prepareNetwork() {
        try {
            socket = new Socket("localhost", 8888);
            System.out.println("서버와 연결되었음!");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            boardDao = new BoardDaoImpl("board", in, out);
            greetingDao = new BoardDaoImpl("greeting", in, out);
            assignmentDao = new AssignmentDaoImpl("assignment", in, out);
            memberDao = new MemberDaoImpl("member", in, out);
        } catch (Exception e) {
            System.out.println("통신 오류!");
            e.printStackTrace();
        }
    }

    void prepareMenu() {
        mainMenu = MenuGroup.getInstance("메인");

        MenuGroup assignmentMenu = mainMenu.addGroup("과제");
        assignmentMenu.addItem("등록", new AssignmentAddHandler(assignmentDao, prompt));
        assignmentMenu.addItem("조회", new AssignmentViewHandler(assignmentDao, prompt));
        assignmentMenu.addItem("변경", new AssignmentModifyHandler(assignmentDao, prompt));
        assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(assignmentDao, prompt));
        assignmentMenu.addItem("목록", new AssignmentListHandler(assignmentDao, prompt));

        MenuGroup boardMenu = mainMenu.addGroup("게시글");
        boardMenu.addItem("등록", new BoardAddHandler(boardDao, prompt));
        boardMenu.addItem("조회", new BoardViewHandler(boardDao, prompt));
        boardMenu.addItem("변경", new BoardModifyHandler(boardDao, prompt));
        boardMenu.addItem("삭제", new BoardDeleteHandler(boardDao, prompt));
        boardMenu.addItem("목록", new BoardListHandler(boardDao, prompt));

        MenuGroup memberMenu = mainMenu.addGroup("회원");
        memberMenu.addItem("등록", new MemberAddHandler(memberDao, prompt));
        memberMenu.addItem("조회", new MemberViewHandler(memberDao, prompt));
        memberMenu.addItem("변경", new MemberModifyHandler(memberDao, prompt));
        memberMenu.addItem("삭제", new MemberDeleteHandler(memberDao, prompt));
        memberMenu.addItem("목록", new MemberListHandler(memberDao, prompt));

        MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
        greetingMenu.addItem("등록", new BoardAddHandler(greetingDao, prompt));
        greetingMenu.addItem("조회", new BoardViewHandler(greetingDao, prompt));
        greetingMenu.addItem("변경", new BoardModifyHandler(greetingDao, prompt));
        greetingMenu.addItem("삭제", new BoardDeleteHandler(greetingDao, prompt));
        greetingMenu.addItem("목록", new BoardListHandler(greetingDao, prompt));

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
                close();
                break;
            } catch(Exception e){
                System.out.println("예외 발생!");
            }
        }
    }

    void close() {
        try (Socket socket = this.socket;
             DataInputStream in = this.in;
             DataOutputStream out = this.out;) {
            out.writeUTF("quit");
            System.out.println(in.readUTF());
        } catch (Exception e) {
            // 서버와 연결을 끊는 과정에서 예외가 발생한 경우 무시함.
            // 왜? 따로 처리할 것이 없음.
        }
    }
}