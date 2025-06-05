package hui.myapp.handler.board;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Board;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import hui.util.List;
import hui.util.Prompt;

import java.util.ArrayList;

/*
게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
- 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 함.
 */
public class BoardAddHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private List<Board> objectRepository;

    /*
    BoardMenu 인스턴스를 생성할 때 반드시 게시판 제목을 설정하도록 강요함.
    생성자란(constructor)?
    => 인스턴스를 사용하기 전에 유효한 상태로 설정하는 작업을 수행하는 메서드
     */
    public BoardAddHandler(List<Board> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {
        try {

            /*
            MenuHandler 인터페이스에 선언된 메서드 대신
            AbstractMenuHandler클래스에 추가된 action()추상 메서드를 구현.
             */
            Board board = new Board();
            board.setTitle(prompt.input("제목? "));
            board.setContent(prompt.input("내용? "));
            board.setWriter(prompt.input("작성자? "));
            board.setCreatedDate(prompt.inputDate("작성일? "));

            /*
            목록에 객체를 추가시키는 코드를 ObjectRepository가 감췄음(캡슐화 함).
            대신 목록에 객체를 추가시킬 수 있도록 메서드를 제공하고 있음.
            따라서 다음과 같이 ObjectRepository가 제공하는 메서드를 사용하여 게시글 객체를 추가해야 함.
             */
            objectRepository.add(board);
        } catch (Exception e) {
            System.out.println("게시글 입력 중 오류 발생!");
            System.out.println("다시 시도하시기 바랍니다.");
        }
    }
}
