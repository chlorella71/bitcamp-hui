package bitcamp.hui.myapp.handler.assignment;

import bitcamp.hui.myapp.vo.Assignment;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.Prompt;

import bitcamp.util.ArrayList;
import bitcamp.util.List;
//import bitcamp.util.ObjectRepository;

public class AssignmentListHandler extends AbstractMenuHandler {

    private List<Assignment> objectRepository;

    public AssignmentListHandler(List<Assignment> objectRepository, Prompt prompt) {
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
