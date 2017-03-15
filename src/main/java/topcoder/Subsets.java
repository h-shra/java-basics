package topcoder;

import java.util.ArrayList;

// Write a method to return all subsets of a set.
public class Subsets {
    public static void main(String args[]) {

    }

    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> inputSet, int index) {
        ArrayList<ArrayList<Integer>> resultSets = new ArrayList<ArrayList<Integer>>();
        if (inputSet.size() == index) {
            resultSets.add(new ArrayList<Integer>());
            return resultSets;
        } else {
            resultSets = getSubsets(inputSet, index + 1);

        }
        return resultSets;
    }

}
