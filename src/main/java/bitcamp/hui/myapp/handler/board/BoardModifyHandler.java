package bitcamp.hui.myapp.handler.board;

import bitcamp.hui.myapp.vo.Board;
import bitcamp.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import bitcamp.util.ArrayList;
import bitcamp.util.List;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 함
public class BoardModifyHandler extends AbstractMenuHandler {

    private List<Board> objectRepository;

    public BoardModifyHandler(List<Board> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository =objectRepository;
    }


    @Override
    public void action() {
        try {
            int index = prompt.inputInt("번호? ");
            Board oldBoard = objectRepository.get(index);

            Board board = new Board();
            board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
            board.setContent(prompt.input("내용(%s)? ", oldBoard.getTitle()));
            board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
            board.setCreatedDate(prompt.inputDate("작성일(%s)? ", oldBoard.getCreatedDate()));

            objectRepository.set(index, board);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("과제 번호가 유효하지 않습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("과제 변경 오류!");
            System.out.println("다시 시도 하세요.");
        } catch (Exception e) {
            System.out.println("실행 오류!");
        }
    }
}
