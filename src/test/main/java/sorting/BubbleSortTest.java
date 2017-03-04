package main.java.sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BubbleSortTest {

    @Test
    public void testSort() throws Exception {
        int [] unsorted = {11, 0, 8, 5, 46, 100};
        SortUtil sortUtil = new SortUtil();
        BubbleSort bubbleSort = new BubbleSort();
        sortUtil.printArray(unsorted);
        bubbleSort.sort(unsorted);
        sortUtil.printArray(unsorted);
        assertEquals(0, unsorted[0]);
    }
}