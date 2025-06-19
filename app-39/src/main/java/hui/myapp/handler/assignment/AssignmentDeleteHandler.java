package hui.myapp.handler.assignment;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.dao.AssignmentDao;
import hui.myapp.vo.Assignment;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import java.util.List;
import hui.util.Prompt;

import java.util.ArrayList;

public class AssignmentDeleteHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private AssignmentDao assignmentDao;

    public AssignmentDeleteHandler(AssignmentDao assignmentDao, Prompt prompt) {
        super(prompt);
        this.assignmentDao = assignmentDao;
    }

    @Override
    protected void action() {
        try {
            int no = this.prompt.inputInt("번호? ");
            if (assignmentDao.delete(no) == 0) {
                System.out.println("과제 번호가 유효하지 않습니다.");
            } else {
                System.out.println("과제를 삭제했습니다.");
            }
        } catch (Exception e) {
            System.out.println("삭제 오류!");
        }
    }
}
