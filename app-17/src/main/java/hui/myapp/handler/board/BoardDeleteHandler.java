package hui.myapp.handler.board;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Board;
import hui.util.AnsiEscape;
import hui.util.Prompt;

public class BoardDeleteHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    BoardRepository boardRepository;

    /*
    BoardMenu 인스턴스를 생성할 때 반드시 게시판 제목을 설정하도록 강요함.
    생성자란(constructor)?
    => 인스턴스를 사용하기 전에 유효한 상태로 설정하는 작업을 수행하는 메서드
     */
    public BoardDeleteHandler(BoardRepository boardRepository, Prompt prompt) {
        this.boardRepository = boardRepository;
        this.prompt = prompt;
    }

    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        if (index < 0 || index >= this.boardRepository.length) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        for (int i = index + 1; i < this.boardRepository.length; i++) {
            this.boardRepository.boards[i - 1] = this.boardRepository.boards[i];
        }
        this.boardRepository.boards[--this.boardRepository.length] = null;
    }
}
