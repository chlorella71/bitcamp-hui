package hui.myapp.handler.member;

import hui.myapp.vo.Member;
import hui.menu.AbstractMenuHandler;
import hui.util.Prompt;

import hui.util.List;
//import bitcamp.util.ObjectRepository;

public class MemberListHandler extends AbstractMenuHandler {

    private List<Member> objectRepository;

    public MemberListHandler(List<Member> objectRepository, Prompt prompt) {
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
