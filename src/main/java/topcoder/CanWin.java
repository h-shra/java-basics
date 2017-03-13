package topcoder;

public class CanWin {

    private final int[] values;

    //{0,1,3,2,1,1,0}
    //index = 2
    //length = 7

    public CanWin(int[] values) {
        this.values = values;
    }

    public boolean canWin(int startIndex) {

        if (startIndex >= values.length || startIndex < 0) {
            return false;
        }

        int x = values[startIndex];//3

        while (values[startIndex] != 0) {
            int temp = startIndex;
            temp = temp + x;
            if (temp > values.length - 1 - startIndex) {
                return false;
            }
        }
        return true;
    }

    public boolean canWinRec(int startIndex) {
        if (startIndex >= values.length || startIndex < 0) {
            return false;
        }

        if (values[startIndex] != 0) {
            int x = values[startIndex];
            boolean result = canWinRec(startIndex + x);
            if (!result) {
                result = canWinRec(startIndex - x);
            }
            return result;
        }
        return false;
    }
}
