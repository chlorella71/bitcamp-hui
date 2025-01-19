package bitcamp.hui.handler.board;

import bitcamp.hui.vo.Board;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

import java.util.ArrayList;
//import bitcamp.util.ObjectRepository;

public class BoardListHandler extends AbstractMenuHandler {

    private ArrayList<Board> objectRepository;

    public BoardListHandler(ArrayList<Board> objectRepository, Prompt prompt) {
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
