package ds.linkedList;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class MyListWithIterator implements List<Integer> {

    private int start;
    private int listSize;

    public class MyIterator implements Iterator<Integer> {
        private final MyListWithIterator myList;
        private int currentIndex;

        public MyIterator(MyListWithIterator list) {
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
