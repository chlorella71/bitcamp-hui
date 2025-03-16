package bitcamp.hui.myapp.handler.board;

import bitcamp.hui.myapp.vo.Board;
import bitcamp.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;
import java.util.List;

public class BoardAddHandler extends AbstractMenuHandler {

    private List<Board> objectRepository;

    public BoardAddHandler(List<Board> objectRepository, Prompt prompt){
        super(prompt);
        this.objectRepository = objectRepository;
    }


    @Override
    public void action() {
        try {
            Board board = new Board();
            board.setTitle(prompt.input("제목? "));
            board.setContent(prompt.input("내용? "));
            board.setWriter(prompt.input("작성자? "));
            board.setCreatedDate(prompt.inputDate("작성일? "));

            objectRepository.add(board);
        } catch (Exception e) {
            System.out.println("과제 입력중 오류 발생!");
            System.out.println("다시 시도하시기 바랍니다.");
        }
    }
}
