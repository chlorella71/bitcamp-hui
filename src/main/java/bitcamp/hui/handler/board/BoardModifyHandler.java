package bitcamp.hui.handler.board;

import bitcamp.hui.vo.Board;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class BoardModifyHandler extends AbstractMenuHandler {

    private ArrayList<Board> objectRepository;

    public BoardModifyHandler(ArrayList<Board> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository =objectRepository;
    }


    @Override
    public void action() {

        int index = prompt.inputInt("번호? ");
        Board oldBoard = objectRepository.get(index);
        if (oldBoard ==null) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        Board board = new Board();
        board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
        board.setContent(prompt.input("내용(%s)? ", oldBoard.getTitle()));
        board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
        board.setCreatedDate(prompt.input("작성일(%s)? ", oldBoard.getCreatedDate()));

        objectRepository.set(index, board);
    }
}
