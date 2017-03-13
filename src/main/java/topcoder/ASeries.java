package topcoder;/*
Problem Statement
*** You may only submit a given problem once - no resubmissions will be accepted. ***

An arithmetic series consists of a sequence of terms such that each term minus
its immediate predecessor gives the same result.
For example, the sequence 3,7,11,15 is the terms of the arithmetic series 3+7+11+15;
each term minus its predecessor equals 4. (Of course there is no requirement on the first term since it has no predecessor.)
Given a collection of integers, we want to find the longest arithmetic series that can be formed by choosing a sub-collection (possibly the entire collection). Create a class ASeries that contains a method longest that is given a values and returns the length of the longest arithmetic series that can be formed from values.

Definition
Class: ASeries
Method: longest
Parameters: int[]
Returns: int
Method signature: int longest(int[] values)
(be sure your method is public)
Limits
Time limit (s): 840.000
Memory limit (MB): 64
Constraints
- values will contain between 2 and 50 elements inclusive.
- Each element of values will be between -1,000,000 and 1,000,000 inclusive.
Examples
0)
{3,8,4,5,6,2,2}
Returns: 5
No arithmetic series using these values is longer than 2,3,4,5,6.
1)
{-1,-5,1,3}
Returns: 3
-1, 1, 3 is an arithmetic series (so is 3,-1,-5).
2)
{-10,-20,-10,-10}
Returns: 3
-10,-10,-10 is an arithmetic series.
*/

import java.util.Arrays;

public class ASeries {
    //{3,8,4,5,6,2,2}
    public int longest(int[] values) {
        Arrays.sort(values);
        int difference = -1;
        //{2,2,3,4,5,6,8}
        for (int i = 0; i < values.length - 1; i++) {
            if (i == 0) {
                //always enter first number into list
            }
            if (difference == values[i + 1] - values[i]) {
                //add i+1 into sequence list
            }
        }
        return 0;
    }
}
