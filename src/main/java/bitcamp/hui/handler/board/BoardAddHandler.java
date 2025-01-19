package bitcamp.hui.handler.board;

import bitcamp.hui.vo.Board;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.lang.module.FindException;
import java.util.ArrayList;

public class BoardAddHandler extends AbstractMenuHandler {

    private ArrayList<Board> objectRepository;

    public BoardAddHandler(ArrayList objectRepository, Prompt prompt){
        super(prompt);
        this.objectRepository = objectRepository;
    }


    @Override
    public void action() {

        Board board = new Board();
        board.setTitle(prompt.input("제목? "));
        board.setContent(prompt.input("내용? "));
        board.setWriter(prompt.input("작성자? "));
        board.setCreatedDate(prompt.input("작성일? "));

        objectRepository.add(board);
    }
}
