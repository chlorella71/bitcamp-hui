package bitcamp.hui.handler.member;

import bitcamp.hui.vo.Member;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;

public class MemberListHandler implements MenuHandler {

    ObjectRepository<Member> objectRepository;

    public MemberListHandler(ObjectRepository<Member> objectRepository) {
        this.objectRepository = objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD +"[%s]\n"+AnsiEscape.ANSI_CLEAR, menu.getTitle());

        System.out.printf("%-10s\t%30s\t%s\n", "이름", "이메일", "가입일");

        Member[] members = objectRepository.toArray(new Member[0]);

        for (Member member: members) {
            System.out.printf("%-10s\t%30s\t%s\n", member.name, member.email, member.createdDate);
        }
    }
}
