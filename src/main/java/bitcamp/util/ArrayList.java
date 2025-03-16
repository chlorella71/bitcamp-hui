package bitcamp.util;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> {

    private Object[] objects = new Object[3];

    public void add(E object) {
        if (this.size == this.objects.length) {
            int oldSize = this.objects.length;
            int newSize = oldSize + (oldSize >> 1);
            this.objects = Arrays.copyOf(this.objects, newSize);
        }

        this.objects[this.size++] = object;
    }

    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }

        Object deleted = this.objects[index];

        System.arraycopy(this.objects, index + 1, this.objects, index, this.size - (index + 1));

        this.objects[--this.size] = null;

        return (E) deleted;
    }
}
