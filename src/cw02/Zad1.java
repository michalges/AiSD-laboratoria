package cw02;

import cw02.Utils.ArrayIterator;

import java.util.Iterator;

public class Zad1 {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(numbers);
        kIterator<Integer> kIt = new kIterator<Integer>(it, 2);

        while (kIt.hasNext()) {
            System.out.println(kIt.next());
        }
    }
}

class kIterator<T> implements Iterator<T> {
    private final Iterator<T> it;
    private final int k;

    private T elemNext = null;
    private boolean bHasNext = true;

    public kIterator(Iterator<T> it, int k) {
        super();
        this.it = it;
        this.k = k;
        findNextValid();
    }

    private void findNextValid() {
        int i = 0;
        while (it.hasNext()) {
            elemNext = it.next();
            i++;
            if (i == k) {
                return;
            }
        }
        bHasNext = false;
        elemNext = null;
    }

    @Override

    public boolean hasNext() {
        return bHasNext;
    }

    @Override
    public T next() {
        T nextValue = elemNext;
        findNextValid();
        return nextValue;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
