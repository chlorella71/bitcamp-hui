package bitcamp.hui.handler.member;

import bitcamp.hui.vo.Member;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

import java.util.ArrayList;
//import bitcamp.util.ObjectRepository;

public class MemberListHandler extends AbstractMenuHandler {

    private ArrayList<Member> objectRepository;

    public MemberListHandler(ArrayList<Member> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    public void action() {

        System.out.printf("%-10s\t%30s\t%s\n", "이름", "이메일", "가입일");

        Member[] members = objectRepository.toArray(new Member[0]);

        for (Member member: members) {
            System.out.printf("%-10s\t%30s\t%s\n", member.getName(), member.getEmail(), member.getCreatedDate());
        }
    }
}
