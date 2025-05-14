package hui.myapp.handler.assignment;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Assignment;
import hui.util.AnsiEscape;
import hui.util.ObjectRepository;
import hui.util.Prompt;

public class AssignmentModifyHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    ObjectRepository<Assignment> objectRepository;

    public AssignmentModifyHandler(ObjectRepository<Assignment> objectRepository, Prompt prompt) {
        this.objectRepository = objectRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        Assignment old = this.objectRepository.get(index);
        if (old == null) {
            System.out.println("과제 번호가 유효하지 않습니다.");
            return;
        }

        Assignment assignment = new Assignment();
        assignment.title = prompt.input("과제명(%s)? ", old.title);
        assignment.content = prompt.input("내용(%s)? ", old.content);
        assignment.deadline = prompt.input("제출 마감일(%s)? ", old.deadline);

        this.objectRepository.set(index, assignment);
    }
}
