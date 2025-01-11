package bitcamp.hui.handler.member;

import bitcamp.hui.vo.Member;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class MemberModifyHandler implements MenuHandler {

    ObjectRepository<Member> objectRepository;
    Prompt prompt;

    public MemberModifyHandler(ObjectRepository<Member> objectRepository, Prompt prompt) {
        this.objectRepository =objectRepository;
        this.prompt=prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD +"[%s]\n"+AnsiEscape.ANSI_CLEAR,menu.getTitle());

        int index = prompt.inputInt("번호? ");
        Member old = objectRepository.get(index);
        if (old == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        Member member = new Member();
        member.email= prompt.input("이메일(%s)? ", old.email);
        member.name=prompt.input("이름(%s)? ", old.name);
        member.password=prompt.input("새 암호? ");
        member.createdDate=prompt.input("가입일(%s)? ", old.createdDate);

        objectRepository.set(index, member);
    }
}
