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

    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        if (this.memberRepository.length == this.memberRepository.members.length) {
            int oldSize = this.memberRepository.members.length;
            int newSize = oldSize + (oldSize >> 1);

            Member[] arr = new Member[newSize];
            for (int i = 0; i < oldSize; i++) {
                arr[i] = this.memberRepository.members[i];
            }
            this.memberRepository.members = arr;
        }

        Member member = new Member();
        member.email = prompt.input("이메일? ");
        member.name = prompt.input("이름? ");
        member.password = prompt.input("암호? ");
        member.createdDate = prompt.input("가입일? ");

        this.memberRepository.members[this.memberRepository.length++] = member;
    }
}
