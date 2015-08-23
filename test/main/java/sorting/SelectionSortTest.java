package main.java.sorting;

import static org.junit.Assert.*;

import main.java.sorting.SelectionSort;
import main.java.sorting.SortUtil;

import org.junit.Test;


public class SelectionSortTest {

    @Test
    public void testSort() throws Exception {
        int [] unsorted = {1, 10, 8, 0, 46, 100, 1, 2};
        SortUtil sortUtil = new SortUtil();
        SelectionSort selectionSort = new SelectionSort();
        sortUtil.printArray(unsorted);
        selectionSort.sort(unsorted);
        sortUtil.printArray(unsorted);
        assertEquals(0, unsorted[0]);
    }
    
    @Test
    public void testSortWithNegNumbers() throws Exception {
        int [] unsorted = {-11, 10, 8, 5, 46, -100, 1, 2};
        SortUtil sortUtil = new SortUtil();
        SelectionSort selectionSort = new SelectionSort();
        sortUtil.printArray(unsorted);
        selectionSort.sort(unsorted);
        sortUtil.printArray(unsorted);
        assertEquals(-100, unsorted[0]);
    }
}