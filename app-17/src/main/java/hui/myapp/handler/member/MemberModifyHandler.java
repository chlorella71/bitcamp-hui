package hui.myapp.handler.member;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
import hui.util.Prompt;

public class MemberModifyHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    MemberRepository memberRepository;

    public MemberModifyHandler(MemberRepository memberRepository, Prompt prompt) {
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

        Member member = this.memberRepository.members[index];
        member.email = prompt.input("이메일(%s)? ", member.email);
        member.name = prompt.input("이름(%s)? ", member.name);
        member.password = prompt.input("새 암호? ");
        member.createdDate = prompt.input("가입일(%s)? ", member.createdDate);
    }
}
