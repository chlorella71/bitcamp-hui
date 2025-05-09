package hui.myapp.handler.assignment;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Assignment;
import hui.util.AnsiEscape;
import hui.util.Prompt;

public class AssignmentListHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    AssignmentRepository assignmentRepository;

    public AssignmentListHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
        this.assignmentRepository = assignmentRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
        System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

        for (Assignment assignment : this.assignmentRepository.toArray()) {
            System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
        }
    }
}
