package bitcamp.hui.handler.board;

import bitcamp.hui.vo.Board;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class BoardViewHandler implements MenuHandler {

    Prompt prompt;
    ObjectRepository<Board> objectRepository;

    public BoardViewHandler(ObjectRepository<Board> objectRepository, Prompt prompt){
        this.prompt=prompt;
        this.objectRepository=objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD +"[%s]\n"+AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        Board board= objectRepository.get(index);
        if (board == null) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        System.out.printf("제목: %s\n", board.title);
        System.out.printf("내용: %s\n", board.content);
        System.out.printf("작성자: %s\n", board.writer);
        System.out.printf("작성일: %s\n", board.createdDate);
    }
}
