package hui.myapp.handler.member;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
import hui.util.ObjectRepository;
import hui.util.Prompt;

public class MemberModifyHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    ObjectRepository objectRepository;

    public MemberModifyHandler(ObjectRepository objectRepository, Prompt prompt) {
        this.objectRepository = objectRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        Member old = (Member) this.objectRepository.get(index);
        if (old == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        Member member = new Member();
        member.email = prompt.input("이메일(%s)? ", old.email);
        member.name = prompt.input("이름(%s)? ", old.name);
        member.password = prompt.input("새 암호? ");
        member.createdDate = prompt.input("가입일(%s)? ", old.createdDate);

        this.objectRepository.set(index, member);
    }
}
