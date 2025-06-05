package hui.myapp.handler.board;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Board;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import hui.util.Iterator;
import hui.util.List;
import hui.util.Prompt;

import java.util.ArrayList;

public class BoardListHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private List<Board> objectRepository;

    /*
    BoardMenu 인스턴스를 생성할 때 반드시 게시판 제목을 설정하도록 강요함.
    생성자란(constructor)?
    => 인스턴스를 사용하기 전에 유효한 상태로 설정하는 작업을 수행하는 메서드
     */
    public BoardListHandler(List<Board> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {   // 논스태틱 메서드 == 인스턴스 메서드
        System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

        /*
        for (Object object : objectRepository.toArray()) {
            Board board = (Board) object;
            System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
        }
         */

        /*
        Repository에 보관된 목록을 배열로 리턴받기
         */
        // 방법1)
        /*
        Board[] boards = new Board[this.objectRepository.size()];
        this.objectRepository.toArray(boards);
         */
        /*
        // 방법2)
        Board[] boards = this.objectRepository.toArray(new Board[0]);
        for (Board board : boards) {
            System.out.printf("%-20s\t%10s\t%s\n", board.getTitle(), board.getWriter(), board.getCreatedDate());
        }

         */

        Iterator<Board> iterator = this.objectRepository.iterator();

        while (iterator.hasNext()) {
            Board board = iterator.next();
            System.out.printf("%-20s\t%10s\t%3$tY-%3$tm-%3$td\n",
                    board.getTitle(),
                    board.getWriter(),
                    board.getCreatedDate());
        }
    }
}
