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

public class BoardModifyHandler extends AbstractMenuHandler {

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
    public BoardModifyHandler(BoardDao boardDao, Prompt prompt) {
        super(prompt);
        this.boardDao = boardDao;
    }

    @Override
    protected void action() {
        try {
            int no = this.prompt.inputInt("번호? ");
            Board oldBoard = boardDao.findBy(no);
            if (oldBoard == null) {
                System.out.println("게시글 번호가 유효하지 않습니다.");
                return;
            }

            Board board = new Board();
            board.setNo(oldBoard.getNo());  // 기존 게시글의 번호를 그대로 설정함.
            board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
            board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
            board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
            board.setCreatedDate(oldBoard.getCreatedDate());

            boardDao.update(board);
            System.out.println("게시글을 변경했습니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("게시글 변경 오류!");
            System.out.println("다시 시도 하세요.");
        } catch (Exception e) {
            System.out.println("실행 오류!");
            e.printStackTrace();
        }

    }
}
