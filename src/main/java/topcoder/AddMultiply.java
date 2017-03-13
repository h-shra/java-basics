package topcoder; /**
 * You are given an y. We are looking for any x that satisfies the following constraints:
 * x has exactly three elements
 * ( x[0] * x[1] ) + x[2] = y
 * Each x[i] must be between -1000 and 1000, inclusive.
 * No x[i] can be equal to 0 or 1.
 * Find and return one such x.
 * <p>
 * If there are multiple valid solutions, you may return any of them.
 * You may assume that for our constraints on y (specified below) at least one valid x always exists.
 * Definition
 * Class: AddMultiply
 * Method: makeExpression
 * Parameters: int
 * Returns: int[]
 * Method signature: int[] makeExpression(int y)
 * (be sure your method is public)
 * Limits
 * Time limit (s): 2.000
 * Memory limit (MB): 256
 * Constraints
 * - y will be between 0 and 500, inclusive.
 * Examples
 * 0)
 * 6
 * Returns: {2, 2, 2 }
 * 2*2 + 2 = 6
 * <p>
 * Note that this is one of many possible solutions. Another solution is:
 * <p>
 * 3*3 + (-3) = 6
 * 1)
 * 11
 * Returns: {2, 3, 5 }
 * 2)
 * 0
 * Returns: {7, 10, -70 }
 * Note that 0 and 1 are not allowed, thus a result like 0 * 0 + 0 would be incorrect.
 * 3)
 * 500
 * Returns: {-400, -3, -700 }
 * Some or all of the returned numbers may be negative.
 * 4)
 * 2
 * Returns: {2, 2, -2 }
 * 5)
 * 5
 * Returns: {5, 2, -5 }
 **/

import java.util.concurrent.ThreadLocalRandom;

Public

class AddMultiply {
    public int[] makeExpression(int y) {
        int[] result = new int[3];
        int min = y;
        int max = y;
        if (y <= 990) {
            max = y + 10;
        }
        if (min <= -990) {
            min = y - 10;
        }

        int random = ThreadLocalRandom.current.nextInt(min, max + 1);


        return result;
    }
}
