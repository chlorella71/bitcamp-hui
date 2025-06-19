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

public class AssignmentViewHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private AssignmentDao assignmentDao;

    public AssignmentViewHandler(AssignmentDao assignmentDao, Prompt prompt) {
        super(prompt);
        this.assignmentDao = assignmentDao;
    }

    @Override
    protected void action() {
        try {
            int no = prompt.inputInt("번호? ");
            Assignment assignment = assignmentDao.findBy(no);
            if (assignment == null) {
                System.out.println("과제 번호가 유효하지 않습니다.");
                return;
            }
            System.out.printf("번호: %s\n", assignment.getNo());
            System.out.printf("과제명: %s\n", assignment.getTitle());
            System.out.printf("내용: %s\n", assignment.getContent());
            System.out.printf("제출 마감일: %s\n", assignment.getDeadline());
        } catch (Exception e) {
            System.out.println("조회 오류!");
        }
    }
}
