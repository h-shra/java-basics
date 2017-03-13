package topcoder;

public class AbbaRunner {
    public static void main(String[] args) {
        ABBA testClass = new ABBA();
        //String output = testClass.canObtain("B", "ABBA");//Possible
        String output = testClass.canObtain("BBBBABABBBBBBA", "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA");
        //String output = testClass.canObtain("A", "BB");//Impossible
        //String output = testClass.canObtain("AB", "ABB");//Impossible
        //String output = testClass.canObtain("BBAB", "ABABABABB");//Impossible
        System.out.println(output);
    }
}
