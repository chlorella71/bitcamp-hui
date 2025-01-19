package bitcamp.hui.handler.assignment;

import bitcamp.hui.vo.Assignment;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class AssignmentDeleteHandler extends AbstractMenuHandler {

    private ArrayList<Assignment> objectRepository;

    public AssignmentDeleteHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }


    @Override
    public void action() {
        int index = prompt.inputInt("번호? ");
        if (objectRepository.remove(index) ==null) {
            System.out.println("과제 번호가 유효하지 않습니다.");
        }
    }
}
