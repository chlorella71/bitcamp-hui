package hui.myapp.handler.member;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import hui.util.Prompt;

import java.util.ArrayList;

public class MemberAddHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private ArrayList<Member> objectRepository;

    public MemberAddHandler(ArrayList<Member> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {

        Member member = new Member();
        member.setEmail(prompt.input("이메일? "));
        member.setName(prompt.input("이름? "));
        member.setPassword(prompt.input("암호? "));
        member.setCreatedDate(prompt.inputDate("가입일? "));

        this.objectRepository.add(member);
    }
}
