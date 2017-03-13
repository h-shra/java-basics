package topcoder;

/*
Given a HashMap where the mapping is:
a => 1
b => 2
...
...
z => 26
Find the maximum number of strings that could be generated from that number. For example:

function("111") = 3
// aaa - 1,1,1
// ak - 1, 11
// ka - 11, 1

function("26") = 2
// bf - 2, 6
// z - 26

function("101") = 1
// ja - 10, 1
// note that there are no other possibilities since 0 does not map to anything

*/
public class Mapping {
    public int getValidCount(String number) {
        if (number == 0) {
            return 0;
        }
        //4101 -> [(4, 10, 1), (10,1), (11,1)]
        List<Set<Integer>> validCombos = getValidNumberCombinations(number);

        Integer count = getMappingCount(validCombos);
        return count;
    }

    public List<Integer> getValidNumberCombinations(String number) {
        return null;
    }

    private Intger getMappingCount(List<Integer> combinationList) {
        return 0;
    }

}
