package cw02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Zad3 {
    public static void main(String[] args) {

        int m = 7;  // dlugosc tablicy

        Integer[] numbers = new Integer[m];
        numbers[0] = 1;
        numbers[1] = 1;

        FibbonciArrayIterator<Integer> it = new FibbonciArrayIterator<Integer>(numbers);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class FibbonciArrayIterator<T> implements Iterator<T> {
    private final T[] array;
    private int pos = 0;

    public FibbonciArrayIterator(T[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return pos < array.length;
    }

    public T next() throws NoSuchElementException {
        if (hasNext()) {
            if(array[pos] == null){
                array[pos] = (T) Integer.valueOf(((Number) array[pos-2]).intValue() + ((Number) array[pos-1]).intValue());
            }
            return array[pos++];
        }
        else throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}