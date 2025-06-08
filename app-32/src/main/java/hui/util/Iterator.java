package hui.util;

/*
데이터를 조회하는 일을 할 객체의 사용법을 정의함.
 */
public interface Iterator<E> {

    // 꺼낼 값이 있는지 물어봄.
    boolean hasNext();

    // 값을 꺼냄.
    E next();
}
