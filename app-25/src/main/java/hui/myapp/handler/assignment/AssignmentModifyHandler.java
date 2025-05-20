package hui.myapp.handler.assignment;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Assignment;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import hui.util.Prompt;

import java.util.ArrayList;

public class AssignmentModifyHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private ArrayList<Assignment> objectRepository;

    public AssignmentModifyHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {
        try {
            int index = prompt.inputInt("번호? ");
            Assignment old = this.objectRepository.get(index);

            Assignment assignment = new Assignment();
            assignment.setTitle(prompt.input("과제명(%s)? ", old.getTitle()));
            assignment.setContent(prompt.input("내용(%s)? ", old.getContent()));
            assignment.setDeadline(prompt.inputDate("제출 마감일(%s)? ", old.getDeadline()));

            this.objectRepository.set(index, assignment);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("과제 번호가 유효하지 않습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("과제 변경 오류!");
            System.out.println("다시 시도 하세요.");
        } catch (Exception e) {
            System.out.println("실행 오류!");
        }
    }
}
