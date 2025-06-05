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

public class BoardDeleteHandler extends AbstractMenuHandler {

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
    public BoardDeleteHandler(List<Board> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {

        try {
            int index = prompt.inputInt("번호? ");
            this.objectRepository.remove(index);
        } catch (Exception e) {
                System.out.println("삭제 오류!");
        }
    }
}
