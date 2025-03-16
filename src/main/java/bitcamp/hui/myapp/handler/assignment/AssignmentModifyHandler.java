package bitcamp.hui.myapp.handler.assignment;

import bitcamp.hui.myapp.vo.Assignment;
import bitcamp.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;
import java.util.List;

public class AssignmentModifyHandler extends AbstractMenuHandler {

    private List<Assignment> objectRepository;

    public AssignmentModifyHandler(List<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    public void action() {
        try {
            int index = prompt.inputInt("번호? ");
            Assignment old = objectRepository.get(index);

            Assignment assignment = new Assignment();
            assignment.setTitle(prompt.input("과제명(%s)? ", old.getTitle()));
            assignment.setContent(prompt.input("내용(%s)? ", old.getContent()));
            assignment.setDeadline(prompt.inputDate("제출 마감일(%s)? ", old.getDeadline()));

            objectRepository.set(index, assignment);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("과제 번호가 유효하지 않습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("과제 변경 오류");
            System.out.println("다시 시도 하세요.");
        } catch (Exception e) {
            System.out.println("실행 오류!");
        }
    }
}
