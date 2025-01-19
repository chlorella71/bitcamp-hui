package bitcamp.hui.handler.member;

import bitcamp.hui.vo.Member;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class MemberViewHandler extends AbstractMenuHandler {

    private ArrayList<Member> objectRepository;

    public MemberViewHandler(ArrayList<Member> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository=objectRepository;
    }

    @Override
    public void action() {

        int index = prompt.inputInt("번호? ");
        Member member = objectRepository.get(index);
        if (member == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        System.out.printf("이메일: %s\n", member.getEmail());
        System.out.printf("이름: %s\n", member.getName());
        System.out.printf("가입일: %s\n",member.getCreatedDate());
    }
}
