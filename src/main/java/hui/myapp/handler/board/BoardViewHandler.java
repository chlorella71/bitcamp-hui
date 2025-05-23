package hui.myapp.handler.board;

import hui.myapp.vo.Board;
import hui.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import hui.util.Prompt;

import hui.util.List;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 함
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
