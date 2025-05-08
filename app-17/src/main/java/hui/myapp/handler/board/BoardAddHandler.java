package hui.myapp.handler.board;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Board;
import hui.util.AnsiEscape;
import hui.util.Prompt;

public class BoardAddHandler implements MenuHandler {

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
    public BoardAddHandler(BoardRepository boardRepository, Prompt prompt) {
        this.boardRepository = boardRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        if (this.boardRepository.length == this.boardRepository.length) {
            int oldSize = this.boardRepository.boards.length;
            int newSize = oldSize + (oldSize >> 1);

            Board[] arr = new Board[newSize];
            for (int i = 0; i < oldSize; i++) {
                arr[i] = this.boardRepository.boards[i];
            }
            this.boardRepository.boards = arr;
        }

        Board board = new Board();
        board.title = prompt.input("제목? ");
        board.content = prompt.input("내용? ");
        board.writer = prompt.input("작성자? ");
        board.createdDate = prompt.input("작성일? ");

        this.boardRepository.boards[this.boardRepository.length++] = board;
    }
}
