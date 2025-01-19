package bitcamp.hui.handler.member;

import bitcamp.hui.vo.Board;
import bitcamp.hui.vo.Member;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class MemberAddHandler extends AbstractMenuHandler {

    private ArrayList<Member> objectRepository;

    public MemberAddHandler(ArrayList<Member> objectRepository, Prompt prompt){
        super(prompt);
        this.objectRepository=objectRepository;
    }

    @Override
    public void action() {

        Member member = new Member();
        member.setEmail(prompt.input("이메일? "));
        member.setName(prompt.input("이름? "));
        member.setPassword(prompt.input("암호? "));
        member.setCreatedDate(prompt.input("가입일? "));

        objectRepository.add(member);

    }
}
