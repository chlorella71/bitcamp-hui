package hui.myapp.handler.member;

import hui.myapp.vo.Member;
import hui.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import hui.util.Prompt;

import hui.util.List;

public class MemberDeleteHandler extends AbstractMenuHandler {

    private List<Member> objectRepository;

    public MemberDeleteHandler(List<Member> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository  ;
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
