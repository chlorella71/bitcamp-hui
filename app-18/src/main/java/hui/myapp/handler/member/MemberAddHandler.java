package hui.myapp.handler.member;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
import hui.util.Prompt;

public class MemberAddHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    MemberRepository memberRepository;

    public MemberAddHandler(MemberRepository memberRepository, Prompt prompt) {
        this.memberRepository = memberRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        Member member = new Member();
        member.email = prompt.input("이메일? ");
        member.name = prompt.input("이름? ");
        member.password = prompt.input("암호? ");
        member.createdDate = prompt.input("가입일? ");

        this.memberRepository.add(member);
    }
}
