package hui.myapp.handler.member;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.dao.MemberDao;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import java.util.Iterator;
import java.util.List;
import hui.util.Prompt;

import java.util.ArrayList;

public class MemberListHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private MemberDao memberDao;

    public MemberListHandler(MemberDao memberDao, Prompt prompt) {
        super(prompt);
        this.memberDao = memberDao;
    }

    @Override
    protected void action() {
        System.out.printf("%-4s\t%-10s\t%30s\t%s\n", "번호", "이름", "이메일", "가입일");

        /*
        for (Object object : this.objectRepository.toArray()) {
            Member member = (Member) object;
            System.out.printf("%-10s\t%30s\t%s\n", member.email, member.name, member.createdDate);
        }
         */
        /*
        Member[] members = new Member[this.objectRepository.size()];
        this.objectRepository.toArray(members);

        for (Member member : members) {
            System.out.printf("%-10s\t%30s\t%s\n", member.getName(), member.getEmail(), member.getCreatedDate());
        }

         */

        List<Member> list = this.memberDao.findAll();

        for (Member member : list) {
            System.out.printf("%-4d\t%-10s\t%30s\t%4$tY-%4$tm-%4$td\n",
                    member.getNo(),
                    member.getName(),
                    member.getEmail(),
                    member.getCreatedDate());
        }
    }
}
