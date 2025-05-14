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
import hui.util.Prompt;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println(AnsiEscape.ANSI_BOLD_RED + "[과제관리 시스템]" + AnsiEscape.ANSI_CLEAR);
        System.out.println();

        Prompt prompt = new Prompt(System.in);
//        new MainMenu(prompt).execute();

        ArrayList<Board> boardRepository = new ArrayList<>();
        ArrayList<Assignment> assignmentRepository = new ArrayList<>();
        ArrayList<Member> memberRepository = new ArrayList<>();
        ArrayList<Board> greetingRepository = new ArrayList<>();

        MenuGroup mainMenu = new MenuGroup("메인");

        MenuGroup assignmentMenu = new MenuGroup("과제");
        assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(assignmentRepository, prompt)));
        assignmentMenu.add(new MenuItem("조회", new AssignmentViewHandler(assignmentRepository, prompt)));
        assignmentMenu.add(new MenuItem("변경", new AssignmentModifyHandler(assignmentRepository, prompt)));
        assignmentMenu.add(new MenuItem("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt)));
        assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(assignmentRepository, prompt)));
        mainMenu.add(assignmentMenu);

        MenuGroup boardMenu = new MenuGroup("게시글");
        boardMenu.add(new MenuItem("등록", new BoardAddHandler(boardRepository, prompt)));
        boardMenu.add(new MenuItem("조회", new BoardViewHandler(boardRepository, prompt)));
        boardMenu.add(new MenuItem("변경", new BoardModifyHandler(boardRepository, prompt)));
        boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(boardRepository, prompt)));
        boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository, prompt)));
        mainMenu.add(boardMenu);

        MenuGroup memberMenu = new MenuGroup("회원");
        memberMenu.add(new MenuItem("등록", new MemberAddHandler(memberRepository, prompt)));
        memberMenu.add(new MenuItem("조회", new MemberViewHandler(memberRepository, prompt)));
        memberMenu.add(new MenuItem("변경", new MemberModifyHandler(memberRepository, prompt)));
        memberMenu.add(new MenuItem("삭제", new MemberDeleteHandler(memberRepository, prompt)));
        memberMenu.add(new MenuItem("목록", new MemberListHandler(memberRepository, prompt)));
        mainMenu.add(memberMenu);

        MenuGroup greetingMenu = new MenuGroup("가입인사");
        greetingMenu.add(new MenuItem("등록", new BoardAddHandler(greetingRepository, prompt)));
        greetingMenu.add(new MenuItem("조회", new BoardViewHandler(greetingRepository, prompt)));
        greetingMenu.add(new MenuItem("변경", new BoardModifyHandler(greetingRepository, prompt)));
        greetingMenu.add(new MenuItem("삭제", new BoardDeleteHandler(greetingRepository, prompt)));
        greetingMenu.add(new MenuItem("목록", new BoardListHandler(greetingRepository, prompt)));
        mainMenu.add(greetingMenu);

        mainMenu.add(new MenuItem("도움말", new HelpHandler(prompt)));

        mainMenu.execute(prompt);

        prompt.close();
    }
}