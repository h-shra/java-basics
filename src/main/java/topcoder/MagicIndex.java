package topcoder;

/*
A magic index in an array A[l.. .n-l] is defined to be an index such that A[i] =
i. Given a sorted array of distinct integers, write a method to find a magic index, if
one exists, in array A.
FOLLOW UP
What if the values are not distinct?
*/
public class MagicIndex {
    public static void main(String args[]) {
        //int[] array = {-12, -1, 2, 10};
        int[] array = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        boolean result = isMagicIndex(array);
        System.out.println(result);
        result = isMagicIndexUsingBS(array);
        System.out.println(result);
    }

    private static boolean isMagicIndex(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == i) {
                System.out.println("isMagicIndex :" + i);
                return true;
            }
        }
        return false;
    }

    public static boolean isMagicIndexUsingBS(int[] inputArray) {
        return usingBS(inputArray, 0, inputArray.length - 1);
    }

    private static boolean usingBS(int[] inputArray, int begin, int end) {
        if (begin < 0 || end > inputArray.length || begin > end) {
            return false;
        }
        int mid = (begin + end) / 2;
        if (inputArray[mid] == mid) {
            System.out.println("isMagicIndexUsingBS :" + mid);
            return true;
        } else if (inputArray[mid] > mid) {
            return usingBS(inputArray, begin, mid - 1);
        } else {
            return usingBS(inputArray, mid + 1, inputArray.length);
        }
    }
}
