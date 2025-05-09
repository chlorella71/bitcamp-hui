package hui.myapp.handler.assignment;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.menu.MenuItem;
import hui.myapp.vo.Assignment;
import hui.util.AnsiEscape;
import hui.util.Prompt;

public class AssignmentAddHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    AssignmentRepository assignmentRepository;


    public AssignmentAddHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
        this.assignmentRepository = assignmentRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        Assignment assignment = new Assignment();
        assignment.title = prompt.input("과제명? ");
        assignment.content = prompt.input("내용? ");
        assignment.deadline = prompt.input("제출 마감일? ");

        this.assignmentRepository.add(assignment);
    }
}
