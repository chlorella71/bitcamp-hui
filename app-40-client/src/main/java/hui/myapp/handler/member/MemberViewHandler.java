package hui.myapp.handler.member;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.dao.MemberDao;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import java.util.List;
import hui.util.Prompt;

import java.util.ArrayList;

public class MemberViewHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private MemberDao memberDao;

    public MemberViewHandler(MemberDao memberDao, Prompt prompt) {
        super(prompt);
        this.memberDao = memberDao;
    }

    @Override
    protected void action() {
        try {
            int no = this.prompt.inputInt("번호? ");
            Member member = this.memberDao.findBy(no);
            if (member == null) {
                System.out.println("회원 번호가 유효하지 않습니다.");
                return;
            }

            System.out.printf("번호: %d\n", member.getNo());
            System.out.println("이메일: " + member.getEmail());
            System.out.println("이름: " + member.getName());
            System.out.printf("가입일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", member.getCreatedDate());
        } catch (Exception e) {
            System.out.println("조회 오류!");
        }
    }
}
