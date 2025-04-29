package hui.util;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        System.out.println(list.remove("xxx"));
        System.out.println(list.remove("ccc"));
        System.out.println(list.remove("ddd"));
        System.out.println(list.remove("aaa"));
        System.out.println(list.remove("bbb"));

        list.add("xxx");
        list.add("yyy");
        list.add("zzz");

//        list.remove(2);
//        list.remove(2);
//        list.remove(0);
//        list.remove(0);

        list.add(0, new String("xxx"));
        list.add(4, new String("yyy"));
        list.add(1, new String("ttt"));

        String[] arr = list.toArray(new String[0]);
//        for (String value : arr) {
//            System.out.printf("%s, ", value);
//        }
        System.out.println(String.join(", ", arr));

        if (arr.length == 0) {
            System.out.printf("empty");
        }

        System.out.println();

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
    }
}
