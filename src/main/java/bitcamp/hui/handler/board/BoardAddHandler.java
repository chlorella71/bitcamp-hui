package bitcamp.hui.handler.board;

import bitcamp.hui.vo.Board;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.lang.module.FindException;

public class BoardAddHandler implements MenuHandler {

    Prompt prompt;
    ObjectRepository<Board> objectRepository;

    public BoardAddHandler(ObjectRepository objectRepository, Prompt prompt){
        this.objectRepository = objectRepository;
        this.prompt = prompt;
    }


    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD+"[%s]\n"+AnsiEscape.ANSI_CLEAR, menu.getTitle());

        Board board = new Board();
        board.title = prompt.input("제목? ");
        board.content = prompt.input("내용? ");
        board.writer = prompt.input("작성자? ");
        board.createdDate = prompt.input("작성일? ");

        objectRepository.add(board);
    }
}
