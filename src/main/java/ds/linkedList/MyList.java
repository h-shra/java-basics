package ds.linkedList;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class MyList implements List<Integer> {

    private int start;
    private int listSize;

    public class MyIterator implements Iterator<Integer> {
        private final MyList myList;
        private int currentIndex;

        public MyIterator(MyList list) {
            this.currentIndex = list.start;
            this.myList = list;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < listSize - 1;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return myList.get(currentIndex++);
            } else
                throw new NoSuchElementException("eol");
        }
    }
}
