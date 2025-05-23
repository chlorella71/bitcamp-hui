//package hui.util;
//
//import java.util.Arrays;
//
//public class ObjectRepository<E> {
//
//    /*
//    수퍼 클래스의 레퍼런스는 서브 클래스의 인스턴스 주소를 담을 수 있음.
//    따라서 Object레퍼런스는 Member, Object, Assignment 등 어떤 객체의 주소라도 담을 수 있음.
//     */
//    // 목록에 관련된 코드를 외부에서 볼 수 없게 감춤.
//    private Object[] objects = new Object[3];
//    private int length = 0;
//
//    /*
//    대신 목록에 값을 추가하거나, 꺼내거나 삭제하려면
//    메서드를 통해 수행하도록 유도함.
//    => 캡슐화
//     */
//    public void add(E object) {
//
//        if (this.length == this.length) {
//            int oldSize = this.objects.length;
//            int newSize = oldSize + (oldSize >> 1);
//
//            /*
//            Object[] arr = new Object[newSize];
//            for (int i = 0; i < oldSize; i++) {
//                arr[i] = this.objects[i];
//            }
//
//            this.objects = arr;
//             */
//
//            /*
//            Object[] arr = new Object[newSize];
//            System.arraycopy(this.objects, 0, arr, 0, oldSize);
//             */
//
//            this.objects = Arrays.copyOf(this.objects, newSize);
//            System.out.printf("새 배열 크기: %d\n", this.objects.length);
//
//        }
//
//        this.objects[this.length++] = object;
//    }
//
//    public E remove(int index) {
//
//        if (index < 0 || index >= this.length) {
//            return null;
//        }
//
//        // 배열에서 삭제하기 전에 임시 보관해 둠.
//        Object deleted = this.objects[index];
//
//        /*
//        for (int i = index + 1; i < this.length; i++) {
//            this.objects[i - 1] = this.objects[i];
//        }
//         */
//
//        System.arraycopy(this.objects, index + 1, this.objects, index, this.length - (index + 1));
//
//        this.objects[--this.length] = null;
//
//        // 삭제한 객체를 리턴함.
//        // 호출하는 쪽에서는 리턴된 객체를 재사용할 수도 있음.
//        return (E) deleted;
//    }
//
//    public Object[] toArray() {
//
//        /*
//        Object[] arr = new Object[this.length];
//        for (int i = 0; i < this.length; i++) {
//            arr[i] = this.objects[i];
//        }
//
//        return arr;
//         */
//
//        return Arrays.copyOf(this.objects, this.length);
//    }
//
//    public E[] toArray(E[] arr) {
//        if (arr.length >= this.length) {
//            System.arraycopy(this.objects, 0, arr, 0, this.length);
//            return arr;
//        }
//        return (E[]) Arrays.copyOf(this.objects, this.length, arr.getClass());
//    }
//
//    public E get(int index) {
//
//        if (index < 0 || index >= this.length) {
//            return null;
//        }
//
//        return (E) this.objects[index];
//    }
//
//    public E set(int index, E object) {
//
//        if (index < 0 || index >= this.length) {
//            return null;
//        }
//
//        Object old = this.objects[index];
//        this.objects[index] = object;
//
//        /*
//        새 객체로 교체하기 전에 이전 객체를 리턴함.
//        호출하는 쪽에서 받아서 재사용할 수 있음.
//         */
//        return (E) old;
//    }
//
//    public int size() {
//        return this.length;
//    }
//}
