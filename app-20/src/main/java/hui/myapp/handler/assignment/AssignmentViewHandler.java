package hui.myapp.handler.assignment;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Assignment;
import hui.util.AnsiEscape;
import hui.util.ObjectRepository;
import hui.util.Prompt;

public class AssignmentViewHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    ObjectRepository<Assignment> objectRepository;

    public AssignmentViewHandler(ObjectRepository<Assignment> objectRepository, Prompt prompt) {
        this.objectRepository = objectRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        Assignment assignment = this.objectRepository.get(index);
        if (assignment == null) {
            System.out.println("과제 번호가 유효하지 않습니다.");
            return;
        }
        System.out.printf("과제명: %s\n", assignment.title);
        System.out.printf("내용: %s\n", assignment.content);
        System.out.printf("제출 마감일: %s\n", assignment.deadline);
    }
}
