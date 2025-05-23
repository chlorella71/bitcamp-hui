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

public class AssignmentDeleteHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private List<Assignment> objectRepository;

    public AssignmentDeleteHandler(List<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {
        try {
            int index = prompt.inputInt("번호? ");
            this.objectRepository.remove(index);
        } catch (Exception e) {
            System.out.println("삭제 오류!");
        }
    }
}
