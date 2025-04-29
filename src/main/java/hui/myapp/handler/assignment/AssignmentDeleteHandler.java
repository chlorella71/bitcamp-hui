package hui.myapp.handler.assignment;

import hui.myapp.vo.Assignment;
import hui.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import hui.util.Prompt;

import hui.util.List;

public class AssignmentDeleteHandler extends AbstractMenuHandler {

    private List<Assignment> objectRepository;

    public AssignmentDeleteHandler(List<Assignment> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }


    @Override
    public void action() {
        try {
            int index = prompt.inputInt("번호? ");
            objectRepository.remove(index);
        } catch (Exception e) {
            System.out.println("삭제 오류!");
        }
    }
}
