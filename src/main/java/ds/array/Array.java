package ds.array;

import java.util.*;

public class Array {

    public static void main(String[] args) {
        Array array = new Array();
        //sorted
        array.intersectOnSortedArrays(new int[]{1, 3, 4, 5, 7}, new int[]{2, 3, 5, 6});
        array.unionOnSortedArrays(new int[]{1, 3, 4, 5, 7}, new int[]{2, 3, 5, 6});
        array.unionOnSortedArrays(new int[]{1, 3}, new int[]{2, 3, 5, 6});
        array.unionOnSortedArrays(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 6, 6, 6, 6, 6, 6}, new int[]{2, 2, 3, 6, 6});
        //unsorted
        array.unsortedUnion(new Integer[]{1, 3, 4, 5, 7}, new Integer[]{2, 3, 5, 6});
        array.unsortedIntersect(new Integer[]{1, 3, 4, 5, 7}, new Integer[]{2, 3, 5, 6});

        System.out.println(array.binarySearch(new Integer[]{1, 4, 5, 8, 9}, 9));

        array.findPairs(new int[]{1, 4, 45, 6, 10, -8, 1, 0}, 10);
        array.findPairsWithSet(new int[]{3, 7, 4, 0, 10, 99, 7, 14}, 7);

        array.sumExceptCurrent(new int[]{3, 7, 4, 0, 10, 9});

        int result = array.findElementWithOddOccurrence(new int[]{2, 6, 2, 6, 6});
        System.out.println(result);
        result = array.findElementWithOddOccurrence(new int[]{2, 2, 2, 5, 5, 4, 4, 4, 4});
        System.out.println(result);
        result = array.findSmallestElement(new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2});
        System.out.println(result);
        Integer[] output = array.findUniqueElements(new Integer[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2});
        System.out.println("Done");
        for (Integer number : output) {
            System.out.println(number);
        }
        output = array.findAllElementsWithOddOccurrence(new Integer[]{1, 3, 2, 5, 4, 5, 2, 4, 3, 9, 5, 2, 4, 4, 2});
        System.out.println("Done");
        for (Integer number : output) {
            System.out.print(number + ".");
        }
        System.out.println();

        List<Integer> kMostFrequent = array.findKMostFrequent(new int[]{1, 2, 2, 2, 2, 2, 3, 3, 3, 6, 6, 6, 6}, 2);
        for (Integer i : kMostFrequent) {
            System.out.print(i + ".");
        }
        System.out.println();

        int[] minInWindow = array.slidingWindowMin(new int[]{2, 1, 3, 4, 6, 3, 8, 9, 10, 12, 56}, 4);
        for (Integer i : minInWindow) {
            System.out.print(i + ".");
        }
        System.out.println();

        int[] maxInWindow = array.maxSlidingWindow(new int[]{2, 1, 3, 4, 6, 3, 8, 9, 10, 12, 56}, 3);
        for (Integer i : maxInWindow) {
            System.out.print(i + ".");
        }
        System.out.println();

        System.out.println(array.countFrequencyInSortedArray(new int[]{2, 2, 2, 2, 3, 3, 3, 6, 6}, 2));
    }

    // [2,1,3,4,6,3,8,9,10,12,56]
    // 2,1,3,4
    // 1,3,4,6
    // 3,4,6,3
    public int[] slidingWindowMin(int[] input, int w) {
        final int[] minLeft = new int[input.length];
        final int[] minRight = new int[input.length];

        minLeft[0] = input[0];
        minRight[input.length - 1] = input[input.length - 1];

        for (int i = 1; i < input.length; i++) {
            minLeft[i] = (i % w == 0) ? input[i] : Math.min(minLeft[i - 1], input[i]);

            final int j = input.length - i - 1;
            minRight[j] = (j % w == 0) ? input[j] : Math.min(minRight[j + 1], input[j]);
        }

        final int[] sliding_min = new int[input.length - w + 1];
        for (int i = 0, j = 0; i + w <= input.length; i++) {
            sliding_min[j++] = Math.min(minRight[i], minLeft[i + w - 1]);
        }

        return sliding_min;
    }

    //{2, 1, 3, 4, 6, 3, 8, 9, 10, 12, 56}, 3
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.poll();//removes first

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.offer(i);//add

            if (i + 1 >= k)
                result[i + 1 - k] = nums[deque.peek()];
        }

        return result;
    }

    public void unionOnSortedArrays(int[] a, int[] b) {
        if (a != null || b != null) {

            int i = 0;
            int j = 0;
            System.out.println("Union: ");
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
            } else if (j < b.length) { //if condition not required, as there can only be 1 array larger than other.
                for (int k = j; k < b.length; k++) {
                    System.out.println(b[k]);
                }
            }
        }
    }

    public void intersectOnSortedArrays(int[] a, int[] b) {
        if (a != null || b != null) {

            int i = 0;
            int j = 0;
            System.out.println("Intersection: ");

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
        Integer[] output;
        if (a.length > b.length) {
            output = compareSmallerWithBigger(a, b);
        } else if (b.length > a.length) {
            output = compareSmallerWithBigger(b, a);
        } else {
            output = compareSmallerWithBigger(a, b);
        }
        for (Integer integer : output) {
            System.out.println(integer);
        }
    }

    public Integer[] compareSmallerWithBigger(Integer[] bigger, Integer[] smaller) {
        List<Integer> resultList = new ArrayList<Integer>(Arrays.asList(bigger));
        for (int i = 0; i < smaller.length; i++) {
            if (!resultList.contains(smaller[i])) { // can sort and do binary search in smaller array instead
                resultList.add(smaller[i]);
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
            boolean present = binarySearch(smaller, bigger[i]);
            if (present) {
                output[index] = bigger[i];
                index++;
            }
        }
        return output;
    }

    public boolean binarySearch(Integer[] array, int value) {
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
    // 0  1  2  3  4  5  6  7  8
    //{2, 2, 2, 2, 3, 3, 3, 6, 6}
    public int countFrequencyInSortedArray(int[] input, int x) {
        int low = 0;
        int high = input.length - 1; //8
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (input[mid] > x) {
                //search left
                high = mid - 1;
            } else if (input[mid] < x) {
                //search right
                low = mid + 1;
            } else {
                // found an occurrence, it may be the first or not. Move on until first occurrence is found
                high = mid;
            }
        }

        if (high < low || input[low] != x) {
            // that means no occurrence
            return -1;
        }

        // 0  1  2  3  4  5  6  7  8
        //{2, 2, 2, 2, 3, 3, 3, 6, 6}
        int first = low;
        high = input.length - 1;

        while (low < high) {
            int mid = low + (high + 1 - low) / 2;
            if (input[mid] > x) {
                //search left
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return high - first + 1;

    }

    //Find 2 integers that have given sum
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

    //Find the number that occurs odd number of time in input array.
    //Works only for 1 number with odd occurrence
    public int findElementWithOddOccurrence(int[] input) {
        int xor = 0;
        for (int i = 0; i < input.length; i++) {
            xor = xor ^ input[i];
        }
        return xor == 0 ? -1 : xor;
    }

    public Integer[] findAllElementsWithOddOccurrence(Integer[] input) {
        Integer[] output = null;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            if (set.contains(input[i])) {
                set.remove(input[i]);//remove the entry as this is even# occurrence
            } else {
                set.add(input[i]);
            }
        }
        output = set.toArray(new Integer[set.size()]);
        return output;
    }


    //Remove multiple occurrences of the numbers from the array.
    private Integer[] findUniqueElements(Integer[] input) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(input));// CANNOT be primitive array
        Set<Integer> set = new HashSet<>();
        set.addAll(arrayList);
        arrayList.clear();
        arrayList.addAll(set);
        Integer[] output = arrayList.toArray(new Integer[arrayList.size()]);// Always mention new <T> [list.size()]

        return output;
    }

    //Find smallest unique number
    public int findSmallestElement(int[] input) {
        int smallest = Integer.MAX_VALUE;
        for (int value : input) {
            if (value < smallest) {
                smallest = value;
            }
        }
        return smallest;
    }

    //Sum of all elements except ith element
    public void sumExceptCurrent(int[] input) {
        int[] result = new int[input.length];
        int i = 0;
        int sum = 0;
        for (int j = 0; j < input.length; ++j) {
            System.out.print(input[j] + " ");
        }
        System.out.println();
        while (i < input.length) {
            int temp = input[i];
            result[i] = sum;
            sum = sum + temp;
            i++;
        }
        for (int j = 0; j < result.length; ++j) {
            System.out.print(result[j] + " ");
        }
        System.out.println();
        i--;
        sum = 0;
        while (i >= 0) {
            int temp = input[i];
            result[i] = result[i] + sum;
            sum = sum + temp;
            i--;
        }
        for (int j = 0; j < result.length; ++j) {
            System.out.print(result[j] + " ");
        }
    }

    //find k most frequent elements
    public List<Integer> findKMostFrequent(int[] array, int k) {

        //Count frequency of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            if (frequencyMap.containsKey(array[i])) {
                frequencyMap.put(array[i], frequencyMap.get(array[i]) + 1);
            } else {
                frequencyMap.put(array[i], 1);
            }
        }

        // create a min heap
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                int i = a.count - b.count;
                return i;
            }
        });

        //maintain a heap of size k.
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<Integer> frequentElements = new ArrayList<>(k);
        //get all elements from the heap
        while (queue.size() > 0) {
            frequentElements.add(queue.poll().num);
        }
        //reverse the order
        Collections.reverse(frequentElements);

        return frequentElements;
    }

    class Pair {
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
