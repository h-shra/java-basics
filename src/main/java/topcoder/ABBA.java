package topcoder;/*
Problem Statement
One day, Jamie noticed that many English words only use the letters A and B. Examples of such words include "AB" (short for abdominal), "BAA" (the noise a sheep makes), "AA" (a type of lava), and "ABBA" (a Swedish pop sensation).


Inspired by this observation, Jamie created a simple game. You are given two s: initial and target.
The goal of the game is to find a sequence of valid moves that will change initial into target.
There are two types of valid moves:

Add the letter A to the end of the string.
Reverse the string and then add the letter B to the end of the string.
Return "Possible" (quotes for clarity) if there is a sequence of valid moves that will change initial into target.
Otherwise, return "Impossible".

Definition
Class: ABBA
Method: canObtain
Parameters: String, String
Returns: String
Method signature: String canObtain(String initial, String target)
(be sure your method is public)
Limits
Time limit (s): 2.000
Memory limit (MB): 256
Constraints
- The length of initial will be between 1 and 999, inclusive.
- The length of target will be between 2 and 1000, inclusive.
- target will be longer than initial.
- Each character in initial and each character in target will be either 'A' or 'B'.
Examples
0)
"B"
"ABBA"
Returns: "Possible"
Jamie can perform the following moves:
Initially, the string is "B".
Jamie adds an 'A' to the end of the string. Now the string is "BA".
Jamie reverses the string and then adds a 'B' to the end of the string. Now the string is "ABB".
Jamie adds an 'A' to the end of the string. Now the string is "ABBA".
Since there is a sequence of moves which starts with "B" and creates the string "ABBA", the answer is "Possible".
1)
"AB"
"ABB"
Returns: "Impossible"
The only strings of length 3 Jamie can create are "ABA" and "BAB".
2)
"BBAB"
"ABABABABB"
Returns: "Impossible"
3)
"BBBBABABBBBBBA"
"BBBBABABBABBBBBBABABBBBBBBBABAABBBAA"
Returns: "Possible"
4)
"A"
"BB"
Returns: "Impossible"
*/

public class ABBA {

    String pass = "Possible";
    String fail = "Impossible";

    //test input B, ABBA
    public String canObtain(String initial, String target) {

        if (initial.length() >= target.length()) {
            return fail;
        }
        if (!initial.contains("A") && !initial.contains("B")) {
            return fail;
        }
        if (initial.length() < 1 || initial.length() > 999) {
            return fail;
        }
        if (target.length() < 2 || target.length() > 1000) {
            return fail;
        }

        String temp = initial;
        boolean passed = false;
        while (temp.length() <= target.length()) {
            temp = makeFirstMove(temp);
            if (temp.equals(target)) {
                passed = true;
            }
            temp = makeSecondMove(temp);
            if (temp.equals(target)) {
                passed = true;
            }
        }

        if (passed) {
            return pass;
        } else {
            return fail;
        }

    }

    private String makeFirstMove(String input) {
        return input + "A";
    }

    private String makeSecondMove(String input) {
        String reversedInput = reverse(input, 0, input.length() - 1);
        return reversedInput + "B";
    }

    private String reverse(String inputS, int start, int end) {
        char[] inputArray = inputS.toCharArray();
        char temp1;
        while (end > start) {
            temp1 = inputArray[start];
            inputArray[start] = inputArray[end];
            inputArray[end] = temp1;
            start++;
            end--;
        }
        String result = new String(inputArray);
        System.out.println("10. After reversal : " + result);
        return result;
    }

}
