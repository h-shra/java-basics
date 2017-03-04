package sorting;

public class InsertionSort {

    /*
    * Select a pivot element and insert elements from remaining unsorted elements before or after the pivot.
    */
    public void sort(int[] inputArr) {
        SortUtil sortUtil = new SortUtil();

        for (int i = 1; i < inputArr.length; i++) {
            int j = i;
            while ((j > 0) && (inputArr[j - 1] > inputArr[j])) {
                sortUtil.swap(j - 1, j, inputArr);
                j = j - 1;
            }
        }
    }

}
