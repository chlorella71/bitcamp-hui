package bitcamp.hui.handler.assignment;

import bitcamp.hui.vo.Assignment;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class AssignmentDeleteHandler implements MenuHandler {

    Prompt prompt;
    ObjectRepository<Assignment> objectRepository;

    public AssignmentDeleteHandler(ObjectRepository<Assignment> objectRepository, Prompt prompt) {
        this.objectRepository = objectRepository;
        this.prompt = prompt;
    }


    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD+"[%s]\n"+AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        if (objectRepository.remove(index) ==null) {
            System.out.println("과제 번호가 유효하지 않습니다.");
        }
    }
}
