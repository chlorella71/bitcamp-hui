package bitcamp.hui.handler.board;

import bitcamp.hui.vo.Board;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class BoardDeleteHandler extends AbstractMenuHandler {

    private ArrayList<Board> objectRepository;

    public BoardDeleteHandler(ArrayList<Board> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository=objectRepository;
    }

    @Override
    public void action() {

        int index = prompt.inputInt("번호? ");
        if (objectRepository.remove(index) == null) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
        }
    }
}
