package bitcamp.hui.handler.board;

import bitcamp.hui.vo.Board;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class BoardViewHandler extends AbstractMenuHandler {

    private ArrayList<Board> objectRepository;

    public BoardViewHandler(ArrayList<Board> objectRepository, Prompt prompt){
        super(prompt);
        this.objectRepository=objectRepository;
    }

    @Override
    public void action() {

        int index = prompt.inputInt("번호? ");
        Board board= objectRepository.get(index);
        if (board == null) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("작성자: %s\n", board.getWriter());
        System.out.printf("작성일: %s\n", board.getCreatedDate());
    }
}
