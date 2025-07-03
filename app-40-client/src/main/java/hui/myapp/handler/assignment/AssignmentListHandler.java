package hui.myapp.handler.assignment;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.dao.AssignmentDao;
import hui.myapp.vo.Assignment;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import java.util.Iterator;
import java.util.List;
import hui.util.Prompt;

import java.util.ArrayList;

public class AssignmentListHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private AssignmentDao assignmentDao;

    public AssignmentListHandler(AssignmentDao assignmentDao, Prompt prompt) {
        super(prompt);
        this.assignmentDao = assignmentDao;
    }

    @Override
    protected void action() {
        System.out.printf("%-4s\t%-20s\t%s\n", "번호", "과제", "제출마감일");

        List<Assignment> list = assignmentDao.findAll();

        for (Assignment assignment : list) {
            System.out.printf("%-4d\t%-20s\t%s\n",
                    assignment.getNo(),
                    assignment.getTitle(),
                    assignment.getDeadline());
        }
    }
}
