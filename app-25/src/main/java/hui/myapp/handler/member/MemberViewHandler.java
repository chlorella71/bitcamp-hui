package hui.myapp.handler.member;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import hui.util.Prompt;

import java.util.ArrayList;

public class MemberViewHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private ArrayList<Member> objectRepository;

    public MemberViewHandler(ArrayList<Member> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {
        try {
            int index = prompt.inputInt("번호? ");
            Member member = this.objectRepository.get(index);

            System.out.println("이메일: " + member.getEmail());
            System.out.println("이름: " + member.getName());
            System.out.println("가입일: " + member.getCreatedDate());
        } catch (Exception e) {
            System.out.println("조회 오류!");
        }
    }
}
