package hui.myapp.handler.member;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
import hui.util.Prompt;

public class MemberDeleteHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    MemberRepository memberRepository;

    public MemberDeleteHandler(MemberRepository memberRepository, Prompt prompt) {
        this.memberRepository = memberRepository;
        this.prompt = prompt;
    }

    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        if (index < 0 || index >= this.memberRepository.length) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        for (int i = index; i < (this.memberRepository.length - 1); i++) {
            this.memberRepository.members[i] = this.memberRepository.members[i + 1];
        }
        this.memberRepository.members[--this.memberRepository.length] = null;
    }
}
