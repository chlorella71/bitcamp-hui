package hui.myapp.handler.member;

import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import hui.util.Prompt;

import java.util.ArrayList;

public class MemberViewHandler implements MenuHandler {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    ArrayList<Member> objectRepository;

    public MemberViewHandler(ArrayList<Member> objectRepository, Prompt prompt) {
        this.objectRepository = objectRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        Member member = this.objectRepository.get(index);
        if (member == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        System.out.println("이메일: " + member.email);
        System.out.println("이름: " + member.name);
        System.out.println("가입일: " + member.createdDate);
    }
}
