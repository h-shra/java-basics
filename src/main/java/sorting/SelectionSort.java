package sorting;


public class SelectionSort {

    /**
     * Select smallest element from unsorted portion of the array and swap with current small.
     * Start with an assumption of first element as current small.
     * @param inputArr
     */
    public void sort(int [] inputArr) {
        int currentSmall, temp;
        for(int i = 0; i< inputArr.length - 1; i ++) {
            currentSmall = i;
            for(int j = i+1 ; j <= inputArr.length - 1; j++) {
                if (inputArr[j] < inputArr[currentSmall]) {
                    currentSmall = j;
                }
            }
            temp = inputArr[currentSmall];
            inputArr[currentSmall] = inputArr[i];
            inputArr[i] = temp;
        }
    }
}
