package bitcamp.hui.handler.assignment;

import bitcamp.util.AnsiEscape;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.hui.vo.Assignment;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class AssignmentAddHandler implements MenuHandler {

    Prompt prompt;
    ObjectRepository<Assignment> objectRepository;

    public AssignmentAddHandler(ObjectRepository<Assignment> objectRepository, Prompt prompt) {
        this.objectRepository=objectRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD+"[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        Assignment assignment = new Assignment();
        assignment.title = prompt.input("과제명? ");
        assignment.content = prompt.input("내용? ");
        assignment.deadline = prompt.input("제출 마감일? ");

        objectRepository.add(assignment);

    }
}
