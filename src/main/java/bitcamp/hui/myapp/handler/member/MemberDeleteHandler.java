package bitcamp.hui.myapp.handler.member;

import bitcamp.hui.myapp.vo.Member;
import bitcamp.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;
import java.util.List;

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
