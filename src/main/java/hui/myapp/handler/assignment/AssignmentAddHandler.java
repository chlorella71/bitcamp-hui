package hui.myapp.handler.assignment;

import hui.menu.AbstractMenuHandler;
import hui.myapp.vo.Assignment;
//import bitcamp.util.ObjectRepository;
import hui.util.Prompt;

import hui.util.List;

public class AssignmentAddHandler extends AbstractMenuHandler {

    private List<Assignment> objectRepository;

    public AssignmentAddHandler(List<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository=objectRepository;
    }

    @Override
    public void action() {
        try {
            Assignment assignment = new Assignment();
            assignment.setTitle(prompt.input("과제명? "));
            assignment.setContent(prompt.input("내용? "));
            assignment.setDeadline(prompt.inputDate("제출 마감일? (예: 2025-03-17) "));

            objectRepository.add(assignment);
        } catch (Exception e) {
            System.out.println("과제 입력 중 오류 발생!");
            System.out.println("다시 시도하시기 바랍니다.");
        }

    }
}
