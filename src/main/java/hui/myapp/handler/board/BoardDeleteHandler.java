package hui.myapp.handler.board;

import hui.myapp.vo.Board;
import hui.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import hui.util.Prompt;

import hui.util.List;

public class BoardDeleteHandler extends AbstractMenuHandler {

    private List<Board> objectRepository;

    public BoardDeleteHandler(List<Board> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository=objectRepository;
    }

    @Override
    public void action() {
        try {
            int index = prompt.inputInt("번호? ");
            objectRepository.remove(index);
        } catch (Exception e) {
            System.out.println("삭제 오류!");
        }
    }
}
