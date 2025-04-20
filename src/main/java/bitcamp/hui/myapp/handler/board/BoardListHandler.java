package bitcamp.hui.myapp.handler.board;

import bitcamp.hui.myapp.vo.Board;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.Prompt;

import bitcamp.util.ArrayList;
import bitcamp.util.List;
//import bitcamp.util.ObjectRepository;


// 게시글의 '목록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 함
public class BoardListHandler extends AbstractMenuHandler {

    private List<Board> objectRepository;

    public BoardListHandler(List<Board> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository=objectRepository;
    }

    @Override
    public void action() {

        System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

        Board[] boards = objectRepository.toArray(new Board[0]);

        for (Board board : boards) {
            System.out.printf("%-20s\t%10s\t%s\n", board.getTitle(), board.getWriter(), board.getCreatedDate() );
        }
    }
}
