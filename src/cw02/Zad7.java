package cw02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Zad7 {
    public static void main(String[] args) {
        Integer[][] array = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}
        };

        Array2DIterator<Integer> it = new Array2DIterator<>(array);
        Array2DIteratorReversed<Integer> itR = new Array2DIteratorReversed<>(array);

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();

        while (itR.hasNext()) {
            System.out.println(itR.next());
        }
    }
}

class Array2DIterator<T> implements Iterator<T> {
    private final T[][] array;
    private int row = 0;
    private int col = 0;

    public Array2DIterator(T[][] array) {
        this.array = array;
    }

    public boolean hasNext() {
        if (row == 0 && col == array.length){
            return false;
        }
        return true;
    }

    public T next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T value = array[col][row];
        row++;
        if (row == array[0].length) {
            row = 0;
            col += 1;
        }
        return value;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}

class Array2DIteratorReversed<T> implements Iterator<T> {
    private final T[][] array;
    private int row;
    private int col;

    public Array2DIteratorReversed(T[][] array) {
        this.array = array;
        this.row = array[0].length - 1;
        this.col = array.length - 1;
    }

    public boolean hasNext() {
        if (row == array[0].length - 1 && col == -1){
            return false;
        }
        return true;
    }

    public T next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T value = array[col][row];
        row--;
        if (row == -1) {
            row = array[0].length - 1;
            col -= 1;
        }
        return value;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
