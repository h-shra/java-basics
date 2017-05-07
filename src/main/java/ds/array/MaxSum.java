package ds.array;

/*
You are given an array of integers (both positive and negative). Find the contiguous
sequence with the largest sum. Return the sum.
EXAMPLE
Input: 2, -8, 3, -2, 4, -10
Outputs 5 (i.e., {3, -2, 4})
Input: 2 3 - 8 - 1 2 4 - 2 3
Output : 7 (2 4 -2 3)

*/
public class MaxSum {
    public static void main(String args[]) {
        MaxSum sum = new MaxSum();
        int[] input = {2, -8, 3, -2, 4, -10};//5
        //int[] input = {-8, 3, -2, -4, -10};
        //int[] input = {-8, -3, -2, -4, -10};//0
        //int[] input = {2, 3, -8, -1, 2, 4, -2, 3};//7
        System.out.println("Max sum: " + sum.getMaxSumOfSubArray(input));
    }

    public int getMaxSumOfSubArray(int[] input) {
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < input.length; i++) {
            sum = sum + input[i];
            if (sum < 0) {
                sum = 0;
            } else if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

}
