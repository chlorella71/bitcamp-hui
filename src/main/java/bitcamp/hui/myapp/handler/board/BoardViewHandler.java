package bitcamp.hui.myapp.handler.board;

import bitcamp.hui.myapp.vo.Board;
import bitcamp.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import bitcamp.util.ArrayList;
import bitcamp.util.List;

public class BoardViewHandler extends AbstractMenuHandler {

    private List<Board> objectRepository;

    public BoardViewHandler(List<Board> objectRepository, Prompt prompt){
        super(prompt);
        this.objectRepository=objectRepository;
    }

    @Override
    public void action() {
        try {
            int index = prompt.inputInt("번호? ");
            Board board = objectRepository.get(index);

            System.out.printf("제목: %s\n", board.getTitle());
            System.out.printf("내용: %s\n", board.getContent());
            System.out.printf("작성자: %s\n", board.getWriter());
            System.out.printf("작성일: %s\n", board.getCreatedDate());
        } catch (Exception e) {
            System.out.println("조회 오류!");
        }
    }
}
