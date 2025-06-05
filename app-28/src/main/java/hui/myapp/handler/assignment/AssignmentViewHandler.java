package hui.myapp.handler.assignment;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Assignment;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import hui.util.List;
import hui.util.Prompt;

import java.util.ArrayList;

public class AssignmentViewHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private List<Assignment> objectRepository;

    public AssignmentViewHandler(List<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {
        try {
            int index = prompt.inputInt("번호? ");
            Assignment assignment = this.objectRepository.get(index);
            System.out.printf("과제명: %s\n", assignment.getTitle());
            System.out.printf("내용: %s\n", assignment.getContent());
            System.out.printf("제출 마감일: %s\n", assignment.getDeadline());
        } catch (Exception e) {
            System.out.println("조회 오류!");
        }
    }
}
