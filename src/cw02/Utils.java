package cw02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Utils {
    public static class ArrayIterator<T> implements Iterator<T> {
        private T[] array;
        private int pos = 0;

        public ArrayIterator(T[] array) {
            this.array = array;
        }

        public boolean hasNext() {
            return pos < array.length;
        }

        public T next() throws NoSuchElementException {
            if (hasNext()) return array[pos++];
            else throw new NoSuchElementException();
        }

//        public int getPos() {
//            return pos;
//        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
