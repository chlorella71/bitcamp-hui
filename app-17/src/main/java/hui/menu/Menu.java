package hui.menu;

import hui.util.Prompt;

/*
Menu를 처리하는 객체의 사용법을 정의함.
 */
public interface Menu {

    /*
    객체를 실행할때 호출할 메서드를 선언.
    구현을 해서는 안됨.
    => 추상 메서드
     */
    public abstract void execute(Prompt prompt);

    public abstract String getTitle();
}
