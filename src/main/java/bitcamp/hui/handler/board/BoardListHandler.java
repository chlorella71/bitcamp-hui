package bitcamp.hui.handler.board;

import bitcamp.hui.vo.Board;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;

public class BoardListHandler implements MenuHandler {

    ObjectRepository<Board> objectRepository;

    public BoardListHandler(ObjectRepository<Board> objectRepository) {
        this.objectRepository=objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD+"[%s]\n"+AnsiEscape.ANSI_CLEAR, menu.getTitle());

        System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

        Board[] boards = objectRepository.toArray(new Board[0]);

        for (Board board : boards) {
            System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate );
        }
    }
}
