package hui;

import java.util.Scanner;

public class Prompt {

    static Scanner in = new Scanner(System.in);

    static String input(String title, Object... args) {
        System.out.print(String.format(title, args));
        return in.nextLine();
    }

    static void close() {
        in.close();
    }
}
