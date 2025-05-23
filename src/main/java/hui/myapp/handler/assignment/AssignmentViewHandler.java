package hui.myapp.handler.assignment;

import hui.myapp.vo.Assignment;
import hui.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import hui.util.Prompt;

import hui.util.List;

public class AssignmentViewHandler extends AbstractMenuHandler {

    private List<Assignment> objectRepository;

    public AssignmentViewHandler(List<Assignment> objectRepository, Prompt prompt){
        super(prompt);
        this.objectRepository = objectRepository;
    }


    @Override
    public void action() {
        try {
            int index = prompt.inputInt("번호? ");
            Assignment assignment = objectRepository.get(index);

            System.out.printf("과제명: %s\n", assignment.getTitle());
            System.out.printf("내용: %s\n", assignment.getContent());
            System.out.printf("제출 마감일: %s\n", assignment.getDeadline());
        } catch (Exception e) {
            System.out.println("조회 오류!");
        }
    }
}
