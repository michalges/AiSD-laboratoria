package cw02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Zad2 {
    public static void main(String[] args) {

        int n = 5;  // liczba poczatkowa
        int m = 5;  // dlugosc tablicy

        Integer[] numbers = new Integer[m];
        numbers[0] = n;

        ArrayGenerationIterator<Integer> it = new ArrayGenerationIterator<Integer>(numbers);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class ArrayGenerationIterator<T> implements Iterator<T> {
    private final T[] array;
    private int pos = 0;

    public ArrayGenerationIterator(T[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return pos < array.length;
    }

    public T next() throws NoSuchElementException {
        if (hasNext()) {
            if(array[pos] == null){
                array[pos] = (T) Integer.valueOf(((Number) array[pos-1]).intValue() + 1);
            }
            return array[pos++];
        }
        else throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}