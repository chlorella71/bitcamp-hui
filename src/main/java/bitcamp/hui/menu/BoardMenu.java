package bitcamp.hui.menu;

import bitcamp.hui.vo.Board;
import bitcamp.hui.util.Prompt;

public class BoardMenu implements Menu{

    Prompt prompt;
    String title;

    Board[] boards = new Board[3];
    int length = 0;

    public BoardMenu(String title, Prompt prompt) {
        this.title = title;
        this.prompt = prompt;
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
                    System.out.println("메뉴 번호가 옳지 않습니다.");
            }
        }
    }

    void add() {
        System.out.println("게시글 등록: ");

        if(length == boards.length) {
            int oldSize = boards.length;
            int newSize= oldSize+ (oldSize>>1);

            Board[] arr = new Board[newSize];
            for (int i = 0; i < oldSize; i++) {
                arr[i] = boards[i];
            }

            boards = arr;
        }

        Board board = new Board();
        board.title = prompt.input("제목? ");
        board.content=prompt.input("내용? ");
        board.writer=prompt.input("작성자? ");
        board.createdDate=prompt.input("작성일? ");

        boards[length++] = board;
    }

    void list() {
        System.out.println("게시글 목록");
        System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

        for (int i=0; i< length; i++) {
            Board board = boards[i];
            System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
        }
    }

    void view() {
        System.out.println("게시글 조회: ");

        int index = Integer.parseInt(prompt.input("번호? "));
        if (index < 0 || index >= length) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        Board board = boards[index];
        System.out.printf("제목: %s\n", board.title);
        System.out.printf("내용: %s\n", board.content);
        System.out.printf("작성자: %s\n", board.writer);
        System.out.printf("작성일: %s\n", board.createdDate);
    }

    void modify() {
        System.out.println("게시글 변경: ");

        int index = Integer.parseInt(prompt.input("번호? "));
        if (index < 0 || index >= length) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        Board board= boards[index];
        board.title=prompt.input("제목(%s)? ", board.title);
        board.content=prompt.input("내용(%s)? ", board.content);
        board.writer=prompt.input("작성자(%s)? ", board.writer);
        board.createdDate=prompt.input("작성일(%s)? ", board.createdDate);
    }

    void delete() {
        System.out.println("게시글 삭제: ");

        int index = Integer.parseInt(prompt.input("번호? "));
        if (index <0 || index >=length) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        for (int i = index; i< (length - 1); i++) {
            boards[i] = boards[i + 1];
        }
        boards[--length] = null;
    }
}