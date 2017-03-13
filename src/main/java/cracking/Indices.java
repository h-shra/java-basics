package cracking;/*
Given an array of integers, write a method to find indices m and n such that if you
sorted elements m through n, the entire array would be sorted. Minimize n - m
(that is, find the smallest such sequence).
EXAMPLE
Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 9, 16, 18, 19
Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
Output: (3, 9)
*/

public class Indices {
  static int minIndex =0;
  static int maxIndex =0;

  public static void main(String args[]) {
    int[] input = {1, 2, 4, 7, 10, 11, 7, 12, 6, 9, 16, 18, 19};
    findIndices(input);
  }

  private static int findLeftSequenceEnd(int[] input) {
    for (int i=1; i<input.length; i++ ) {
      if (input[i] < input[i-1]) {
        return i-1;
      }
    }
    return input.length -1;
  }

  private static int findRightSequenceStart(int[] input) {
    for (int i = input.length-2; i>=0; i-- ) {
      if (input[i] > input[i+1]) {
        return i+1;
      }
    }
    return 0;
  }

  private static void findMinMaxInMiddle(int leftEnd, int rightStart, int[] input) {
    minIndex = leftEnd;
    maxIndex = rightStart;
    for (int i = leftEnd; i < rightStart; i++) {
      if (input[i] >= input[i+1]) {
        minIndex = i+1;
      }
      if (input[i] <= input[i+1]) {
        maxIndex = i+1;
      }
    }
  }

  private static void findM(int[] input, int minIndex, int start) {
    for (int i = start; i > 0; i--) {
      if (input[i] < input[minIndex]) {
        System.out.println("M index: "+ (i+1));
        System.out.println("M element: "+ input[i+1]);
        break;
      }
    }
  }

  private static void findN(int[] input, int maxIndex, int start) {
    for (int i = start; i < input.length; i++) {
      if (input[i] > input[maxIndex]) {
        System.out.println("N index: "+ (i-1));
        System.out.println("N element: "+ input[i-1]);
        break;
      }
    }
  }

  public static void findIndices(int[] input) {
    int leftEnd = findLeftSequenceEnd(input);
    System.out.println("findLeftSequenceEnd : " +leftEnd);
    int rightStart = findRightSequenceStart(input);
    System.out.println("findRightSequenceStart : " +rightStart);
    findMinMaxInMiddle(leftEnd, rightStart, input);
    findMinMaxInMiddle(leftEnd, rightStart, input);
    System.out.println("minIndex : " +minIndex);
    System.out.println("maxIndex : " +maxIndex);

    findM(input, minIndex, leftEnd);
    findN(input, maxIndex, rightStart);
  }
}
