package hui.myapp.handler.board;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Board;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import hui.util.Prompt;

import java.util.ArrayList;

public class BoardModifyHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private ArrayList<Board> objectRepository;

    /*
    BoardMenu 인스턴스를 생성할 때 반드시 게시판 제목을 설정하도록 강요함.
    생성자란(constructor)?
    => 인스턴스를 사용하기 전에 유효한 상태로 설정하는 작업을 수행하는 메서드
     */
    public BoardModifyHandler(ArrayList<Board> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {

        int index = prompt.inputInt("번호? ");
        Board oldBoard = this.objectRepository.get(index);
        if (oldBoard == null) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        Board board = new Board();
        board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
        board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
        board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
        board.setCreatedDate(prompt.inputDate("작성일(%s)? ", oldBoard.getCreatedDate()));

        this.objectRepository.set(index, board);
    }
}
