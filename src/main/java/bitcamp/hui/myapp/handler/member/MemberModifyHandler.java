package bitcamp.hui.myapp.handler.member;

import bitcamp.hui.myapp.vo.Member;
import bitcamp.menu.AbstractMenuHandler;
//import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import bitcamp.util.ArrayList;
import bitcamp.util.List;

public class MemberModifyHandler extends AbstractMenuHandler {

    private List<Member> objectRepository;

    public MemberModifyHandler(List<Member> objectRepository, Prompt prompt) {
        super(prompt);
        this.objectRepository =objectRepository;
    }

    @Override
    public void action() {
        try {
            int index = prompt.inputInt("번호? ");
            Member old = objectRepository.get(index);

            Member member = new Member();
            member.setEmail(prompt.input("이메일(%s)? ", old.getEmail()));
            member.setName(prompt.input("이름(%s)? ", old.getName()));
            member.setPassword(prompt.input("새 암호? "));
            member.setCreatedDate(prompt.inputDate("가입일(%s)? ", old.getCreatedDate()));

            objectRepository.set(index, member);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("과제 번호가 유효하지 않습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("과제 변경 오류!");
            System.out.println("다시 시도하세요.");
        } catch (Exception e) {
            System.out.println("실행 오류!");
        }
    }
}
