package bitcamp.hui.handler.assignment;

import bitcamp.hui.vo.Assignment;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

import java.util.ArrayList;
//import bitcamp.util.ObjectRepository;

public class AssignmentListHandler extends AbstractMenuHandler {

    private ArrayList<Assignment> objectRepository;

    public AssignmentListHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository= objectRepository;
    }

    @Override
    public void action() {
        System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

        Assignment[] assignments = new Assignment[objectRepository.size()];
        objectRepository.toArray(assignments);

        for (Assignment assignment : assignments) {
            System.out.printf("%-20s\t%s\n", assignment.getTitle(), assignment.getDeadline());
        }
    }
}
