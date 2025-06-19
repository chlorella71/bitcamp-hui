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

public class MemberModifyHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private MemberDao memberDao;

    public MemberModifyHandler(MemberDao memberDao, Prompt prompt) {
        super(prompt);
        this.memberDao = memberDao;
    }

    @Override
    protected void action() {
        try {
            int no = this.prompt.inputInt("번호? ");
            Member old = this.memberDao.findBy(no);
            if (old == null) {
                System.out.println("회원 번호가 유효하지 않습니다.");
                return;
            }

            Member member = new Member();
            member.setNo(old.getNo());
            member.setEmail(this.prompt.input("이메일(%s)? ", old.getEmail()));
            member.setName(this.prompt.input("이름(%s)? ", old.getName()));
            member.setPassword(this.prompt.input("새 암호? "));
            member.setCreatedDate(old.getCreatedDate());

            this.memberDao.update(member);
            System.out.println("회원을 변경했습니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("회원 번호가 유효하지 않습니다");
        } catch (IllegalArgumentException e) {
            System.out.println("회원 변경 오류!");
            System.out.println("다시 시도하세요.");
        } catch (Exception e) {
            System.out.println("실행 오류!");
            e.printStackTrace();
        }

    }
}
