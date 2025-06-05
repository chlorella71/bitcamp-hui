package hui.myapp.handler.assignment;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.menu.MenuItem;
import hui.myapp.vo.Assignment;
import hui.util.AnsiEscape;
import hui.util.List;
import hui.util.Prompt;

import java.util.ArrayList;
//import hui.util.ObjectRepository;

public class AssignmentAddHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private List<Assignment> objectRepository;


    public AssignmentAddHandler(List<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {
        try {
            Assignment assignment = new Assignment();
            assignment.setTitle(prompt.input("과제명? "));
            assignment.setContent(prompt.input("내용? "));
            assignment.setDeadline(prompt.inputDate("제출 마감일? "));

            this.objectRepository.add(assignment);
        } catch (Exception e) {
            System.out.println("과제 입력 중 오류 발생!");
            System.out.println("다시 시도하시기 바랍니다.");
        }
    }
}
