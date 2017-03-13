package topcoder;/*
You are converting old code for a new compiler version. Each "->" string should be replaced by ".", but this replacement shouldn't be done inside comments. A comment is a string that starts with "//" and terminates at the end of the line.

You will be given a program containing the old code. Return a containing the converted version of the code.

Definition
Class: AccessChanger
Method: convert
Parameters: String[]
Returns: String[]
Method signature: String[] convert(String[] program)
(be sure your method is public)
Constraints
- program will have between 1 and 50 elements, inclusive.
- Each element of program will contain between 1 and 50 characters, inclusive.
- Each character in program will have ASCII value between 32 and 127, inclusive.
Examples
0)
{"Test* t = new Test();", "t->a = 1;", "t->b = 2;", "t->go(); // a=1, b=2 --> a=2, b=3"}
Returns: {"Test* t = new Test();", "t.a = 1;", "t.b = 2;", "t.go(); // a=1, b=2 --> a=2, b=3" }
1)
{"---> // the arrow --->", "---", "> // the parted arrow"}
Returns: {"--. // the arrow --->", "---", "> // the parted arrow" }
2)
{"->-> // two successive arrows ->->"}
Returns: {".. // two successive arrows ->->" }
*/

import java.util.ArrayList;

public class AccessChanger {

    public static void main(String[] args) {
        //String[] program = {"Test* t = new Test();", "t->a = 1;", "t->b = 2;", "t->go();// a=1, //b=2 --> a=2, b=3"};
        String[] program = {"---> // the arrow --->", "---", "> // the parted arrow"};
        String[] out = convert(program);
        for (String s : out) {
            System.out.println(s);
        }
    }

    public static String[] convert(String[] program) {
        ArrayList<String> output = new ArrayList();
        for (String s : program) {
            if (!s.contains("//")) {
                output.add(s.replace("->", "."));
            } else {
                String[] twoS = s.split("//", 2);
                if (!twoS[0].equals(null)) {
                    twoS[0] = twoS[0].replace("->", ".");
                }
                output.add(twoS[0] + "//" + twoS[1]);
            }
        }

        return output.toArray(new String[output.size()]);
    }


}
