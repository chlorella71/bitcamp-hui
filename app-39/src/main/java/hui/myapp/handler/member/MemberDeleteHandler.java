package hui.myapp.handler.member;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.dao.BoardDao;
import hui.myapp.dao.MemberDao;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import java.util.List;
import hui.util.Prompt;

import java.util.ArrayList;

public class MemberDeleteHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private MemberDao memberDao;

    public MemberDeleteHandler(MemberDao memberDao, Prompt prompt) {
        super(prompt);
        this.memberDao = memberDao;
    }

    @Override
    protected void action() {
        try {
            int no = this.prompt.inputInt("번호? ");
            if (memberDao.delete(no) == -1) {
                System.out.println("회원 번호가 유효하지 않습니다.");
            } else {
                System.out.println("회원을 삭제했습니다.");
            }
        } catch (Exception e) {
            System.out.println("삭제 오류!");
        }

    }
}
