package sorting;

public class SortUtil {

    public static void swap(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void printArray(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            System.out.print(inputArr[i] + "\t");
        }
        System.out.println();
    }

}
