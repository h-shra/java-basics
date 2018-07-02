package sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BubbleSortTest {

    private BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void testSort() throws Exception {
        int[] unsorted = {11, 0, 8, 5, 46, 100};
        SortUtil.printArray(unsorted);
        bubbleSort.sort(unsorted);
        SortUtil.printArray(unsorted);
        assertEquals(0, unsorted[0]);
    }

    @Test
    public void testSortAscending() throws Exception {
        int[] unsorted = {11, 0, 8, 5, 46, 100};
        SortUtil.printArray(unsorted);
        bubbleSort.bubbleSortAscending(unsorted);
        SortUtil.printArray(unsorted);
        assertEquals(0, unsorted[0]);
    }

    @Test
    public void testSortDescending() throws Exception {
        int[] unsorted = {9, 0, 7, 12, 1};
        SortUtil.printArray(unsorted);
        bubbleSort.bubbleSortDescending(unsorted);
        SortUtil.printArray(unsorted);
        assertEquals(12, unsorted[0]);
        unsorted = new int[]{11, 0, 8, 5, 46, 100};
        SortUtil.printArray(unsorted);
        bubbleSort.bubbleSortDescending(unsorted);
        SortUtil.printArray(unsorted);
        assertEquals(100, unsorted[0]);
    }
}