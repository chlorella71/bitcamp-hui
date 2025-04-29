package hui.myapp.handler.member;

import hui.myapp.vo.Member;
import hui.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import hui.util.Prompt;

import hui.util.List;

public class MemberViewHandler extends AbstractMenuHandler {

    private List<Member> objectRepository;

    public MemberViewHandler(List<Member> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository=objectRepository;
    }

    @Override
    public void action() {
        try {
            int index = prompt.inputInt("번호? ");
            Member member = objectRepository.get(index);

            System.out.printf("이메일: %s\n", member.getEmail());
            System.out.printf("이름: %s\n", member.getName());
            System.out.printf("가입일: %s\n", member.getCreatedDate());
        } catch (Exception e) {
            System.out.println("조회 오류!");
        }
    }
}
