package sorting;

public class BubbleSort {
    SortUtil sortUtil = new SortUtil();

    public void sort(int[] inputArr) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < inputArr.length - 1; i++) {
                if (inputArr[i] > inputArr[i + 1]) {
                    sortUtil.swap(i, i + 1, inputArr);
                    swapped = true;
                }
            }
        }
    }

    public void bubbleSortAscending(int[] toSort) {

        for (int i = 0; i < toSort.length - 1; i++) {
            for (int j = 1; j < toSort.length - i; j++) {
                if (toSort[j - 1] > toSort[j]) {
                    int temp = toSort[j - 1];
                    toSort[j - 1] = toSort[j];
                    toSort[j] = temp;
                }
            }
        }

    }
}
