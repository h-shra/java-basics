package sorting;

public class BubbleSort {

    /**
     * Compare each pair of adjacent elements in-place.
     * Swap them if they are in the wrong order.
     * Pass through array until no swap is needed.
     * Worst, Average O(n^2)
     * Best O(n) for already sorted array
     * Space O(1)
     *
     * @param inputArr
     */
    public void sort(int[] inputArr) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < inputArr.length - 1; i++) {
                if (inputArr[i] > inputArr[i + 1]) {
                    SortUtil.swap(i, i + 1, inputArr);
                    swapped = true;
                }
            }
        }
    }

    /**
     * During each of the inner loop's last iteration,
     * largest element is placed at array.length - i'th position
     *
     * @param inputArr
     */
    //[9, 0, 7, 12, 1]
    public void bubbleSortAscending(int[] inputArr) {

        for (int i = 0; i < inputArr.length - 1; i++) {
            for (int j = 1; j < inputArr.length - i; j++) {
                if (inputArr[j - 1] > inputArr[j]) {
                    int temp = inputArr[j - 1];
                    inputArr[j - 1] = inputArr[j];
                    inputArr[j] = temp;
                }
            }
        }

    }

    /**
     * During each of the inner loop's last iteration,
     * smallest element is placed at the array.length-i'th position
     *
     * @param inputArr
     */
    //Begin: 9, 0, 7, 12, 1
    //1st:   9, 0, 7, 12, 1
    //2nd:   9, 7, 0, 12, 1
    //3rd:   9, 7, 12, 0, 1
    //4th:   9, 7, 12, 1, 0
    //i changed
    //1st:   9, 7, 12, 1, 0
    //2nd:   9, 12, 7, 1, 0
    public void bubbleSortDescending(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = 0; j < inputArr.length - i - 1; j++) {
                if (inputArr[j] < inputArr[j + 1]) {
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[j + 1];
                    inputArr[j + 1] = temp;
                }
            }
        }
    }
}
