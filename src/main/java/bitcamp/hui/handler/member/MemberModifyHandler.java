package bitcamp.hui.handler.member;

import bitcamp.hui.vo.Member;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class MemberModifyHandler extends AbstractMenuHandler {

    private ArrayList<Member> objectRepository;

    public MemberModifyHandler(ArrayList<Member> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository =objectRepository;
    }

    @Override
    public void action() {

        int index = prompt.inputInt("번호? ");
        Member old = objectRepository.get(index);
        if (old == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        Member member = new Member();
        member.setEmail(prompt.input("이메일(%s)? ", old.getEmail()));
        member.setName(prompt.input("이름(%s)? ", old.getName()));
        member.setPassword(prompt.input("새 암호? "));
        member.setCreatedDate(prompt.input("가입일(%s)? ", old.getCreatedDate()));

        objectRepository.set(index, member);
    }
}
