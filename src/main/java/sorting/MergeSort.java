package sorting;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] input = new int[]{55, 2, 3, 8, 11, 99, 0};
        sort.mergeSort(input);
        for (int i : input) {
            System.out.println(i);
        }
    }

    // O(n log n)
    private void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int low, int high) {

        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    public void merge(int[] array, int low, int mid, int high) {

        int[] temp = new int[array.length];

        for (int i = low; i <= high; i++) {
            temp[i] = array[i];
        }

        int current = low;
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                array[current] = temp[i];
                i++;
            } else {
                array[current] = temp[j];
                j++;
            }
            current++;
        }

        while (i <= mid) {
            array[current] = temp[i];
            i++;
            current++;
        }

    }

}
