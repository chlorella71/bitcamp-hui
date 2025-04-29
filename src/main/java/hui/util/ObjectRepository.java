//package bitcamp.util;
//
//import bitcamp.hui.vo.Assignment;
//
//import java.util.Arrays;
//
//public class ObjectRepository<E> {
//
//    private Object[] objects = new Object[3];
//    private int length=0;
//
//    public void add(E object) {
//        if (length== objects.length) {
//
//            int oldSize = objects.length;
//            int newSize = oldSize + (oldSize / 2);
//
//            objects = Arrays.copyOf(objects, newSize);
//        }
//
//        objects[length++] = object;
//    }
//
//    public E remove(int index) {
//        if (index < 0 || index >= length) {
//            return null;
//        }
//
//        Object deleted = objects[index];
//
//        System.arraycopy(objects, index+1, objects, index, length - (index +1));
//        objects[--length] = null;
//
//        return (E) deleted;
//    }
//
//    public Object[] toArray() {
//        return Arrays.copyOf(objects, length);
//    }
//
//    public E[] toArray(E[] arr) {
//        if (arr.length >= length) {
//            System.arraycopy(objects, 0, arr, 0, length);
//            return arr;
//        }
//        return (E[]) Arrays.copyOf(objects, length, arr.getClass());
//    }
//
//    public E get(int index) {
//        if (index <0 || index >= length) {
//            return null;
//        }
//        return (E) objects[index];
//    }
//
//    public E set(int index, Object object) {
//        if (index <0 || index >= length) {
//            System.out.println("과제 번호가 유효하지 않습니다.");
//            return null;
//        }
//
//        Object old = objects[index];
//        objects[index] = object;
//
//        return (E) old;
//    }
//
//    public int size() {
//        return length;
//    }
//}
