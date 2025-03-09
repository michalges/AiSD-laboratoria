package cw02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Zad6 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        numbers2.add(12);
        numbers2.add(8);
        numbers2.add(2);
        numbers2.add(23);
        Iterator<Integer> iterator = numbers2.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(iterator.next());
        System.out.println(numbers2);

        int n = 5;

        Integer[] numbers = {1, 2, 3, 4, 5};
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(numbers);

        System.out.println(it.next());
        System.out.println(it.next());
        it.remove();
        System.out.println(it.next());

        for (Integer number: numbers) {
            System.out.print(number + " ");
        }
    }
}

class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int pos = 0;
    private int lastPos = -1;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return pos < array.length;
    }

    public T next() throws NoSuchElementException {
        if (hasNext()) {
            lastPos = pos;
            return array[pos++];
        }
        else throw new NoSuchElementException();
    }

    public void remove() {
        if (lastPos == -1) {
            throw new IllegalStateException();
        }
        T[] newArray = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), array.length - 1);
        for (int i = 0; i < lastPos; i++) {
            newArray[i] = array[i];
        }
        for (int i = lastPos; i < array.length - 1; i++) {
            newArray[i] = array[i + 1];
        }
        pos--;
        array = newArray;
    }
}
