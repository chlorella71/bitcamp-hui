package bitcamp.hui.handler.board;

import bitcamp.hui.vo.Board;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class BoardModifyHandler implements MenuHandler {

    Prompt prompt;
    ObjectRepository<Board> objectRepository;

    public BoardModifyHandler(ObjectRepository<Board> objectRepository, Prompt prompt) {
        this.prompt=prompt;
        this.objectRepository =objectRepository;
    }


    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD+"[%s]\n"+AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        Board oldBoard = objectRepository.get(index);
        if (oldBoard ==null) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        Board board = new Board();
        board.title=prompt.input("제목(%s)? ", oldBoard.title);
        board.content=prompt.input("내용(%s)? ", oldBoard.content);
        board.writer=prompt.input("작성자(%s)? ", oldBoard.writer);
        board.createdDate=prompt.input("작성일(%s)? ", oldBoard.createdDate);

        objectRepository.set(index, board);
    }
}
