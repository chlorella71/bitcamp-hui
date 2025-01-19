package bitcamp.hui.handler.assignment;

import bitcamp.hui.vo.Assignment;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class AssignmentViewHandler extends AbstractMenuHandler {

    private ArrayList<Assignment> objectRepository;

    public AssignmentViewHandler(ArrayList<Assignment> objectRepository, Prompt prompt){
        super(prompt);
        this.objectRepository = objectRepository;
    }


    @Override
    public void action() {
        int index = prompt.inputInt("번호? ");
        Assignment assignment = objectRepository.get(index);
        if (assignment ==null) {
            System.out.println("과제 번호가 유효하지 않습니다.");
            return;
        }

        System.out.printf("과제명: %s\n", assignment.getTitle());
        System.out.printf("내용: %s\n", assignment.getContent());
        System.out.printf("제출 마감일: %s\n", assignment.getDeadline());
    }
}
