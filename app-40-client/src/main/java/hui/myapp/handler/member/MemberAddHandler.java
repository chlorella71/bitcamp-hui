package hui.myapp.handler.member;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.dao.MemberDao;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import java.util.Date;
import java.util.List;
import hui.util.Prompt;

import java.util.ArrayList;

public class MemberAddHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private MemberDao memberDao;

    public MemberAddHandler(MemberDao memberDao, Prompt prompt) {
        super(prompt);
        this.memberDao = memberDao;
    }

    @Override
    protected void action() {
        try {
            Member member = new Member();
            member.setEmail(prompt.input("이메일? "));
            member.setName(prompt.input("이름? "));
            member.setPassword(prompt.input("암호? "));
            member.setCreatedDate(new Date());

            this.memberDao.add(member);
        } catch (Exception e) {
            System.out.println("회원정보 입력 중 오류 발생!");
            System.out.println("다시 시도하시기 바랍니다.");
        }

    }
}
