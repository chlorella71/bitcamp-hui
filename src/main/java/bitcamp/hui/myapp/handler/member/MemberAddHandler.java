package bitcamp.hui.myapp.handler.member;

import bitcamp.hui.myapp.vo.Member;
import bitcamp.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import bitcamp.util.ArrayList;
import bitcamp.util.List;

public class MemberAddHandler extends AbstractMenuHandler {

    private List<Member> objectRepository;

    public MemberAddHandler(List<Member> objectRepository, Prompt prompt){
        super(prompt);
        this.objectRepository=objectRepository;
    }

    @Override
    public void action() {
        try {
            Member member = new Member();
            member.setEmail(prompt.input("이메일? "));
            member.setName(prompt.input("이름? "));
            member.setPassword(prompt.input("암호? "));
            member.setCreatedDate(prompt.inputDate("가입일? "));

            objectRepository.add(member);
        } catch (Exception e) {
            System.out.println("과제 입력 중 오류 발생!");
            System.out.println("다시 시도하시기 바랍니다.");
        }

    }
}
