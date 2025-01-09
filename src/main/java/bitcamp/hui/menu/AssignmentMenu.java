package bitcamp.hui.menu;

import bitcamp.hui.vo.Assignment;
import bitcamp.hui.util.Prompt;

public class AssignmentMenu implements Menu {

    Prompt prompt;

    String title;
    Assignment[] assignments= new Assignment[3];
    int length = 0;

    public AssignmentMenu(String title, Prompt prompt) {
        this.title = title;
        this.prompt =prompt;
    }

    void printMenu() {
        System.out.printf("[%s]\n", title);
        System.out.println("1. 등록");
        System.out.println("2. 조회");
        System.out.println("3. 변경");
        System.out.println("4. 삭제");
        System.out.println("5. 목록");
        System.out.println("0. 이전");
    }

    public void execute() {
        printMenu();

        while(true) {
            String input= prompt.input("메인/%s> ", title);

            switch(input) {
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
                    System.out.println("메뉴 번호가 옳지 않습니다.");
            }
        }
    }

    void add() {
        System.out.println("과제 등록: ");

        if (length == assignments.length) {
            int oldSize = assignments.length;
            int newSize= oldSize + (oldSize /2);

            Assignment[] arr = new Assignment[newSize];
            for (int i = 0; i< oldSize; i++) {
                arr[i] = assignments[i];
            }

            assignments= arr;
        }
        Assignment assignment= new Assignment();
        assignment.title=prompt.input("과제명? ");
        assignment.content=prompt.input("내용? ");
        assignment.deadline=prompt.input("제출 마감일? ");

        assignments[length] = assignment;
        length++;
    }

    void list() {
        System.out.println("과제 목록: ");
        System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

        for (int i = 0; i < length; i++) {
            Assignment assignment = assignments[i];
            System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
        }
    }

    void view() {
        System.out.println("과제 조회: ");

        int index = Integer.parseInt(prompt.input("번호? "));
        if (index < 0 || index >= length) {
            System.out.println("과제 번호가 유효하지 않습니다.");
            return;
        }

        Assignment assignment = assignments[index];
        System.out.printf("과제명: %s\n", assignment.title);
        System.out.printf("내용: %s\n", assignment.content);
        System.out.printf("제출 마감일: %s\n", assignment.deadline);
    }

    void modify() {
        System.out.println("과제 변경: ");

        int index=Integer.parseInt(prompt.input("번호? "));
        if (index < 0 || index >= length) {
            System.out.println("과제 번호가 유효하지 않습니다.");
            return;
        }

        Assignment assignment = assignments[index];
        assignment.title=prompt.input("과제명(%s)? ", assignment.title);
        assignment.content=prompt.input("내용(%s)?", assignment.content);
        assignment.deadline= prompt.input("제출 마감일(%s)? ", assignment.deadline);
    }

    void delete() {
        System.out.println("과제 삭제");

        int index=Integer.parseInt(prompt.input("번호? "));
        if (index <0 || index >= length) {
            System.out.println("과제 번호가 유효하지 않습니다.");
        }

        for (int i= index; i < (length - 1); i++) {
            assignments[i] = assignments[i+1];
        }
        length--;
        assignments[length] =null;
    }
}
