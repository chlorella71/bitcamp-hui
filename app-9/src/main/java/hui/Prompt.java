package hui;

import java.util.Scanner;

public class Prompt {

    static Scanner in = new Scanner(System.in);

    static String input(String title) {
        System.out.printf("%s> ", title);
        return in.nextLine();
    }

    static void close() {
        in.close();
    }
}
