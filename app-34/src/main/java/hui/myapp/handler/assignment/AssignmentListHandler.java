package hui.myapp.handler.assignment;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
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

    private List<Assignment> objectRepository;

    public AssignmentListHandler(List<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {
        System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

        /*
        for (Object object : this.objectRepository.toArray()) {
            Assignment assignment = (Assignment) object;
            System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
        }
         */

        /*
        Assignment[] assignments = new Assignment[this.objectRepository.size()];
        this.objectRepository.toArray(assignments);

        for (Assignment assignment : assignments) {
            System.out.printf("%-20s\t%s\n", assignment.getTitle(), assignment.getDeadline());
        }

         */

        Iterator<Assignment> iterator = this.objectRepository.iterator();

        while (iterator.hasNext()) {
            Assignment assignment = iterator.next();
            System.out.printf("%-20s\t%s\n", assignment.getTitle(), assignment.getDeadline());
        }
    }
}
