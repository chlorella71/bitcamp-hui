package hui.myapp.handler.member;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
import hui.util.ObjectRepository;
import hui.util.Prompt;

public class MemberDeleteHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    ObjectRepository<Member> objectRepository;

    public MemberDeleteHandler(ObjectRepository<Member> objectRepository, Prompt prompt) {
        this.objectRepository = objectRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        if (objectRepository.remove(index) == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
        }
    }
}
