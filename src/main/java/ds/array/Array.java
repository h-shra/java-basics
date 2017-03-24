package ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Array {

    public static void main(String[] args) {
        Array array = new Array();
        // array.union(new int[] {1, 3, 4, 5, 7}, new int[]{2, 3, 5, 6});
        // array.intersect(new int[] {1, 3, 4, 5, 7}, new int[]{2, 3, 5, 6});

        // array.union(new int[] {1,2,2,2,2,2,2,3,6,6,6,6,6,6}, new int[]{2,2,3,6,6,});
        // array.unsortedUnion(new Integer[] {1, 3, 4, 5, 7}, new Integer[]{2, 3, 5, 6});
        //array.unsortedIntersect(new Integer[] { 1, 3, 4, 5, 7 }, new Integer[] { 2, 3, 5, 6 });

        // System.out.println(array.binarySearchInSmaller(new Integer[] {1, 4, 5, 8, 9}, 9));

        array.findPairs(new int[] {1, 4, 45, 6, 10, -8, 1}, 2);
        array.findPairsWithSet(new int[]{3, 7, 4, 0, 10, 99, 7, 14}, 7);

    }

    public void union(int[] a, int[] b) {
        if (a != null || b != null) {

            int i = 0;
            int j = 0;
            while (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    System.out.println(a[i]);
                    i++;
                } else if (a[i] > b[j]) {
                    System.out.println(b[j]);
                    j++;
                } else {
                    System.out.println(a[i]);
                    i++;
                    j++;
                }
            }
            if (i < a.length) {
                for (int k = i; k < a.length; k++) {
                    System.out.println(a[k]);
                }
            }
            if (j < b.length) {
                for (int k = j; k < b.length; k++) {
                    System.out.println(b[k]);
                }
            }
        }
    }

    public void intersect(int[] a, int[] b) {
        if (a != null || b != null) {

            int i = 0;
            int j = 0;
            while (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    i++;
                } else if (a[i] > b[j]) {
                    j++;
                } else {
                    System.out.println(a[i]);
                    i++;
                    j++;
                }
            }
        }
    }

    public void unsortedUnion(Integer[] a, Integer[] b) {
        Integer[] output = null;
        if (a.length > b.length) {
            output = a;
            output = copySecond(output, b);
        } else if (b.length > a.length) {
            output = b;
            output = copySecond(output, a);
        } else {
            output = a;
            output = copySecond(output, b);
        }
        for (Integer res : output) {
            System.out.println(res);
        }
    }

    public Integer[] copySecond(Integer[] result, Integer[] second) {
        List<Integer> resultList = new ArrayList<Integer>(Arrays.asList(result));
        for (int i = 0; i < second.length; i++) {
            if (!resultList.contains(second[i])) { // can sort and do binary search in smaller array instead
                resultList.add(second[i]);
            }
        }
        Integer[] output = new Integer[resultList.size()];
        return resultList.toArray(output);
    }

    public void unsortedIntersect(Integer[] a, Integer[] b) {
        Integer[] output = null;
        if (a.length > b.length) {
            output = sortAndSearch(b, a);
        } else if (b.length > a.length) {
            output = sortAndSearch(a, b);
        } else {
            output = sortAndSearch(a, b);
        }
        for (Integer res : output) {
            System.out.println(res);
        }
    }

    public Integer[] sortAndSearch(Integer[] smaller, Integer[] bigger) {
        Integer[] output = new Integer[smaller.length];
        Arrays.sort(smaller);
        int index = 0;
        for (int i = 0; i < bigger.length; i++) {
            boolean present = binarySearchInSmaller(smaller, bigger[i]);
            if (present) {
                output[index] = bigger[i];
                index++;
            }
        }
        return output;
    }

    public boolean binarySearchInSmaller(Integer[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        return binarySearch(array, low, high, value);

    }

    public boolean binarySearch(Integer[] array, int low, int high, int value) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > value) {
                return binarySearch(array, low, mid - 1, value);
            } else if (array[mid] < value) {
                return binarySearch(array, mid + 1, high, value);
            } else if (array[mid] == value) {
                return true;
            }
        }
        return false;
    }

    public void findPairs(int[] array, int sum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int currentSum = array[left] + array[right];

            if (currentSum == sum) {
                System.out.println("Pair : " + array[left] + ", " + array[right]);
                right--;
                left++;
            } else if (currentSum > sum) {
                right--;
            } else if (currentSum < sum) {
                left++;
            }
        }

    }

    public void findPairsWithSet(int[] array, int sum) {
        Set<Integer> set = new HashSet<>(array.length);
        for (int i = 0; i < array.length; i++) {
            int diff = sum - array[i];
            if (set.contains(diff)) {
                System.out.println("Pair : " + array[i] + ", " + diff);
            } else {
                set.add(array[i]);
            }
        }
    }


}
