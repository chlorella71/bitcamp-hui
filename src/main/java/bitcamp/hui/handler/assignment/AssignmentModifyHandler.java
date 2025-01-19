package bitcamp.hui.handler.assignment;

import bitcamp.hui.vo.Assignment;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class AssignmentModifyHandler extends AbstractMenuHandler {

    private ArrayList<Assignment> objectRepository;

    public AssignmentModifyHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    public void action() {
        int index = prompt.inputInt("번호? ");
        Assignment old = objectRepository.get(index);
        if (old == null) {
            System.out.println("과제 번호가 유효하지 않습니다.");
            return;
        }

        Assignment assignment = new Assignment();
        assignment.setTitle(prompt.input("과제명(%s)? ", old.getTitle()));
        assignment.setContent(prompt.input("내용(%s)? ", old.getContent()));
        assignment.setDeadline(prompt.input("제출 마감일(%s)? ", old.getDeadline()));

        objectRepository.set(index, assignment);
    }
}
