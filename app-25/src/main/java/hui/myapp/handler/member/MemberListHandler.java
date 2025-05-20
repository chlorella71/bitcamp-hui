package hui.myapp.handler.member;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import hui.util.Prompt;

import java.util.ArrayList;

public class MemberListHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private ArrayList<Member> objectRepository;

    public MemberListHandler(ArrayList<Member> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {
        System.out.printf("%-10s\t%30s\t%s\n", "이름", "이메일", "가입일");

        /*
        for (Object object : this.objectRepository.toArray()) {
            Member member = (Member) object;
            System.out.printf("%-10s\t%30s\t%s\n", member.email, member.name, member.createdDate);
        }
         */
        Member[] members = new Member[this.objectRepository.size()];
        this.objectRepository.toArray(members);

        for (Member member : members) {
            System.out.printf("%-10s\t%30s\t%s\n", member.getName(), member.getEmail(), member.getCreatedDate());
        }
    }
}
