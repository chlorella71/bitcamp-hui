package bitcamp.hui.handler.member;

import bitcamp.hui.vo.Member;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class MemberViewHandler implements MenuHandler {

    ObjectRepository<Member> objectRepository;
    Prompt prompt;

    public MemberViewHandler(ObjectRepository<Member> objectRepository, Prompt prompt) {
        this.objectRepository=objectRepository;
        this.prompt=prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD +"[%s]\n"+ AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = prompt.inputInt("번호? ");
        Member member = objectRepository.get(index);
        if (member == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        System.out.printf("이메일: %s\n", member.email);
        System.out.printf("이름: %s\n", member.name);
        System.out.printf("가입일: %s\n",member.createdDate);
    }
}
