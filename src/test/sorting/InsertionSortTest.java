package sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsertionSortTest {

    @Test
    public void testSort() throws Exception {
        int[] unsorted = {1, 10, 8, 0, 46, 100, 1, 2};
        SortUtil sortUtil = new SortUtil();
        InsertionSort insertionSort = new InsertionSort();
        sortUtil.printArray(unsorted);
        insertionSort.sort(unsorted);
        sortUtil.printArray(unsorted);
        assertEquals(0, unsorted[0]);
    }
}