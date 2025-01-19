package bitcamp.hui.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.hui.vo.Assignment;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class AssignmentAddHandler extends AbstractMenuHandler {

    private ArrayList<Assignment> objectRepository;

    public AssignmentAddHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository=objectRepository;
    }

    @Override
    public void action() {
        Assignment assignment = new Assignment();
        assignment.setTitle(prompt.input("과제명? "));
        assignment.setContent(prompt.input("내용? "));
        assignment.setDeadline(prompt.input("제출 마감일? "));

        objectRepository.add(assignment);

    }
}
