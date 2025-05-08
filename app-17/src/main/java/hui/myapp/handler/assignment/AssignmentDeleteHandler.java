package hui.myapp.handler.assignment;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Assignment;
import hui.util.AnsiEscape;
import hui.util.Prompt;

public class AssignmentDeleteHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    AssignmentRepository assignmentRepository;

    public AssignmentDeleteHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
        this.assignmentRepository = assignmentRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        if (index < 0 || index >= this.assignmentRepository.length) {
            System.out.println("과제 번호가 유효하지 않습니다.");
            return;
        }

        for (int i = index; i < (this.assignmentRepository.length-1); i++) {
            this.assignmentRepository.assignments[i] = this.assignmentRepository.assignments[i + 1]; // 다음 레퍼런스의 값을 삭제하려는 현재 레퍼런스로 이동
        }

        this.assignmentRepository.length--;
        this.assignmentRepository.assignments[this.assignmentRepository.length] = null; // 마지막 레퍼런스는 null로 초기화
    }
}
