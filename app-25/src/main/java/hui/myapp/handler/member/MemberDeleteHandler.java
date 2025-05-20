package hui.myapp.handler.member;

import hui.menu.AbstractMenuHandler;
import hui.menu.Menu;
import hui.menu.MenuHandler;
import hui.myapp.vo.Member;
import hui.util.AnsiEscape;
//import hui.util.ObjectRepository;
import hui.util.Prompt;

import java.util.ArrayList;

public class MemberDeleteHandler extends AbstractMenuHandler {

//    /*
//    의존 객체(Dependency Object ==> dependency);
//    - 클래스가 작업을 수행할 때 사용하는 객체
//     */
//    Prompt prompt;

    private ArrayList<Member> objectRepository;

    public MemberDeleteHandler(ArrayList<Member> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {
        try {
            int index = prompt.inputInt("번호? ");
            this.objectRepository.remove(index);
        } catch (Exception e) {
            System.out.println("삭제 오류!");
        }

    }
}
