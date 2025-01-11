package bitcamp.hui.handler.member;

import bitcamp.hui.vo.Board;
import bitcamp.hui.vo.Member;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class MemberAddHandler implements MenuHandler {

    Prompt prompt;
    ObjectRepository<Member> objectRepository;

    public MemberAddHandler(ObjectRepository<Member> objectRepository, Prompt prompt){
        this.prompt=prompt;
        this.objectRepository=objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD+"[%s]\n"+AnsiEscape.ANSI_CLEAR, menu.getTitle());

        Member member = new Member();
        member.email= prompt.input("이메일? ");
        member.name = prompt.input("이름? ");
        member.password = prompt.input("암호? ");
        member.createdDate=prompt.input("가입일? ");

        objectRepository.add(member);

    }
}
