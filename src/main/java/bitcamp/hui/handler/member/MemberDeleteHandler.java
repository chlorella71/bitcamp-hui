package bitcamp.hui.handler.member;

import bitcamp.hui.vo.Member;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class MemberDeleteHandler extends AbstractMenuHandler {

    private ArrayList<Member> objectRepository;

    public MemberDeleteHandler(ArrayList<Member> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository  ;
    }

    @Override
    public void action() {

        int index = prompt.inputInt("번호? ");
        if (objectRepository.remove(index) == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
        }
    }
}
