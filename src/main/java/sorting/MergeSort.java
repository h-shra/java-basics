package sorting;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] input = new int[] {55,2,3,8,11,99,0};
        sort.mergeSort(input);
        for (int i : input) {
            System.out.println(i);
        }
    }

    //O(n log n)
    private void mergeSort(int[] array) {
        doSort(array, 0, array.length - 1);
    }

    private void doSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            doSort(array, low, mid);
            doSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }

    }

    private void merge(int[] array, int low, int mid, int high) {
        int[] helper = new int[array.length];
        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array

        while (i <= mid && j <= high) {
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= mid) {
            array[k] = helper[i];
            k++;
            i++;
        }
    }

}
