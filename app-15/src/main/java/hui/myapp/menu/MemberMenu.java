package hui.myapp.menu;

import hui.myapp.vo.Member;
import hui.util.Prompt;

public class MemberMenu {

    /*
    의존 객체(Dependency Object ==> dependency);
    - 클래스가 작업을 수행할 때 사용하는 객체
     */
    Prompt prompt;

    String title;

    Member[] members = new Member[3];
    int length = 0;

    public MemberMenu(String title, Prompt prompt) {
        this.title = title;
        this.prompt = prompt;
    }

    void printMenu() {
        System.out.printf("[%s]\n", this.title);
        System.out.println("1. 등록");
        System.out.println("2. 조회");
        System.out.println("3. 변경");
        System.out.println("4. 삭제");
        System.out.println("5. 목록");
        System.out.println("0. 이전");
    }

    void execute() {
        printMenu();
        while (true) {
            String input = prompt.input("메인/%s> ", title);

            switch (input) {
                case "1":
                    add();
                    break;
                case "2":
                    view();
                    break;
                case "3":
                    modify();
                    break;
                case "4":
                    delete();
                    break;
                case "5":
                    list();
                    break;
                case "0":
                    return;
                case "menu":
                    printMenu();
                    break;
                default:
                    System.out.println("메뉴 번호가 옳지 않습니다!");
            }
        }
    }

    void add() {
        System.out.println("회원 등록:");

        if (length == members.length) {
            int oldSize = members.length;
            int newSize = oldSize + (oldSize >> 1);

            Member[] arr = new Member[newSize];
            for (int i = 0; i < oldSize; i++) {
                arr[i] = members[i];
            }
            members = arr;
        }

        Member member = new Member();
        member.email = prompt.input("이메일? ");
        member.name = prompt.input("이름? ");
        member.password = prompt.input("암호? ");
        member.createdDate = prompt.input("가입일? ");

        members[length++] = member;
    }

    void list() {
        System.out.println("회원 목록:");
        System.out.printf("%-10s\t%30s\t%s\n", "이름", "이메일", "가입일");

        for (int i = 0; i < length; i++) {
            Member member = members[i];
            System.out.printf("%-10s\t%30s\t%s\n", member.email, member.name, member.createdDate);
        }
    }

    void view() {
        System.out.println("회원 조회:");

        int index = prompt.inputInt("번호? ");
        if (index < 0 || index >= length) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        Member member = members[index];
        System.out.println("이메일: " + member.email);
        System.out.println("이름: " + member.name);
        System.out.println("가입일: " + member.createdDate);
    }

    void modify() {
        System.out.println("회원 변경:");

        int index = prompt.inputInt("번호? ");
        if (index < 0 || index >= length) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        Member member = members[index];
        member.email = prompt.input("이메일(%s)? ", member.email);
        member.name = prompt.input("이름(%s)? ", member.name);
        member.password = prompt.input("새 암호? ");
        member.createdDate = prompt.input("가입일(%s)? ", member.createdDate);
    }

    void delete() {
        System.out.println("회원 삭제:");

        int index = prompt.inputInt("번호? ");
        if (index < 0 || index >= length) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        for (int i = index; i < (length - 1); i++) {
            members[i] = members[i + 1];
        }
        members[--length] = null;
    }
}
