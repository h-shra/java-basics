package cracking;

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
    //int[] input = {2, -8, 3, -2, 4, -10};
    //int[] input = {-8, 3, -2, -4, -10};
    //int[] input = {-8, -3, -2, -4, -10};
    int[] input = {2, 3, -8, -1, 2, 4, -2, 3};
    System.out.println("Max sum: "+getMaxSum(input));
  }

  public static int getMaxSum(int[] input) {
    int sum = 0;
    int maxSum = 0;
    for (int i = 0; i< input.length ; i++ ) {
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
