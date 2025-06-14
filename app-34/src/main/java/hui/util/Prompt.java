package hui.util;

import java.io.InputStream;
import java.util.Scanner;
import java.sql.Date;

public class Prompt {

    private Scanner in;

    public Prompt(InputStream inputStream) {
        in = new Scanner(inputStream);
    }

    public String input(String title, Object... args) {
        System.out.print(String.format(title, args));
        return in.nextLine();
    }

    public int inputInt(String title, Object... args) {
        String str = this.input(title, args);
        return Integer.parseInt(str);
    }

    public float inputFloat(String title, Object... args) {
        String str = this.input(title, args);
        return Float.parseFloat(str);
    }

    public boolean inputBoolean(String title, Object... args) {
        String str = this.input(title, args);
        return Boolean.parseBoolean(str);
    }

    public Date inputDate(String title, Object... args) {
        return Date.valueOf(this.input(title, args));
    }

    public void close() {
        in.close();
    }
}
