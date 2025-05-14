package hui.myapp.handler.assignment;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.menu.MenuItem;
import hui.myapp.vo.Assignment;
import hui.util.AnsiEscape;
import hui.util.Prompt;

import java.util.ArrayList;
//import hui.util.ObjectRepository;

public class AssignmentAddHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    ArrayList<Assignment> objectRepository;


    public AssignmentAddHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
        this.objectRepository = objectRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        Assignment assignment = new Assignment();
        assignment.setTitle(prompt.input("과제명? "));
        assignment.setContent(prompt.input("내용? "));
        assignment.setDeadline(prompt.input("제출 마감일? "));

        this.objectRepository.add(assignment);
    }
}
