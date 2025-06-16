package hui.util;

public class ListTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("aaa");    // aaa,
        list.add("bbb");    // aaa, bbb,
        list.add("ccc");    // aaa, bbb, ccc,
        list.add("ddd");    // aaa, bbb, ccc, ddd,

        System.out.println(list.remove("xxx")); // aaa, bbb, ccc, ddd, -> false
        System.out.println(list.remove("ccc")); // aaa, bbb, ddd, -> true
        System.out.println(list.remove("ddd")); // aaa, bbb, -> true
        System.out.println(list.remove("aaa")); // bbb, -> true
        System.out.println(list.remove("bbb")); // -> true

        list.add("aaa");    // aaa,
        list.add("bbb");    // aaa, bbb,
        list.add("ccc");    // aaa, bbb, ccc,
        list.add("ddd");    // aaa, bbb, ccc, ddd

        list.remove(2); // aaa, bbb, ddd
        list.remove(2); // aaa, bbb,
        list.remove(0); // bbb,
        list.remove(0); //

        list.add("aaa");    // aaa,
        list.add("bbb");    // aaa, bbb,
        list.add("ccc");    // aaa, bbb, ccc,
        list.add("ddd");    // aaa, bbb, ccc, ddd,

        // 맨 앞
        list.add(0, new String("xxx")); // xxx, aaa, bbb, ccc, ddd,

        // 맨 뒤
        list.add(5, new String("yyy")); // xxx, aaa, bbb, ccc, ddd, yyy,

        // 기존 값 자리
        list.add(1, new String("eee")); // xxx, eee, aaa, bbb, ccc, ddd, yyy,
        list.add(3, new String("fff")); // xxx, eee, aaa, fff, bbb, ccc, ddd, yyy,
        list.add(7, new String("ggg")); // xxx, eee, aaa, fff, bbb, ccc, ddd, ggg, yyy,

        String[] arr = list.toArray(new String[0]);
        for (String value : arr) {
            System.out.printf("%s, ", value);   // xxx, eee, aaa, fff, bbb, ccc, ddd, ggg, yyy,
        }
        System.out.println();

        System.out.println(list.get(0));    // xxx
        System.out.println(list.get(1));    // eee
        System.out.println(list.get(2));    // aaa
        System.out.println(list.get(3));    // fff
        System.out.println(list.get(4));    // bbb
    }
}
