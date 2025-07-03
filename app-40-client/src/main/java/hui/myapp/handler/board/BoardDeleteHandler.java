package hui.myapp.handler.board;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.dao.BoardDao;
import hui.myapp.vo.Board;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import java.util.List;
import hui.util.Prompt;

import java.util.ArrayList;

public class BoardDeleteHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private BoardDao boardDao;

    /*
    BoardMenu 인스턴스를 생성할 때 반드시 게시판 제목을 설정하도록 강요함.
    생성자란(constructor)?
    => 인스턴스를 사용하기 전에 유효한 상태로 설정하는 작업을 수행하는 메서드
     */
    public BoardDeleteHandler(BoardDao boardDao, Prompt prompt) {
        super(prompt);
        this.boardDao = boardDao;
    }

    @Override
    protected void action() {

        try {
            int no = this.prompt.inputInt("번호? ");
            if (boardDao.delete(no) == 0) {
                System.out.println("게시글 번호가 유효하지 않습니다.");
            } else {
                System.out.println("삭제했습니다.");
            }
        } catch (Exception e) {
                System.out.println("삭제 오류!");
        }
    }
}
