package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringManipulation {

    public static void main(String[] args) {

        testSplit("hi there");
        testSplit("hello");
        permutation("hi there");

        System.out.println(insertStar("test"));
        System.out.println(insertStar("A"));

        String[] strings = say_what_you_see(new String[]{"12", "21"});
        // String[] strings = say_what_you_see(new String[]{});

        for (String s : strings) {
            System.out.println(s);
        }
        char[] a = new char[]{0, 0, 0, 0, 0};

        int[] ar = new int[]{2, 4, 8, 10, 12, 14, 16};
        System.out.println(findMissing(ar));

        System.out.println("String related functions");

        boolean flag = hasUniqueChars("testme");
        System.out.println(flag);

        flag = hasUniqueChars("abc101");
        System.out.println(flag);

        String input = "My name is xyz.";
        char[] inputArr = input.toCharArray();
        reverseChars(inputArr, 0, input.length() - 1);
        System.out.println(inputArr);
        input = "My name is xyz.";
        input = reverseWords(input);
        System.out.println(input);

        /*System.out.println(getAsciiCode('.'));
        System.out.println(getAsciiCode('0'));
        System.out.println(getAsciiCode('9'));

        System.out.println(isValidNumber("127875.55"));
        System.out.println(isValidNumber("127875.55a"));

        // double ans = power(2,3);
        double ans = power(2, 4);
        ans = hoch(2, 3);
        System.out.println(ans);

        permutation("test");*/

        System.out.println(swapVowels("unitedstates"));
        System.out.println(swapVowelsUsingSpace("unitedstates"));
        System.out.println(swapVowels("alliteration"));
        System.out.println(compressConsonants("apple"));

    }

    public static void testSplit(String input) {
        List<String> params = new ArrayList<>();
        if (input != null) {
            params = Arrays.asList(input.split(" "));
        }

        System.out.println(params.size());
    }

    public static boolean hasUniqueChars(String input) {

        if (input.length() > 256) {
            return false;
        }

        boolean[] charSet = new boolean[256];

        for (int i = 0; i < input.length(); i++) {
            int asciiValue = input.charAt(i);
            if (charSet[asciiValue]) {
                return false;
            } else {
                charSet[asciiValue] = true;
            }
        }
        return true;
    }

    //O(n/2)
    public static void reverseChars(char[] inputArray, int start, int end) {

        // when only input is String input, add following
        // char[] inputArray = input.toCharArray();
        // reverseChars(inputArr, 0, input.length() - 1);
        char temp;
        while (end > start) {
            temp = inputArray[start];
            inputArray[start] = inputArray[end];
            inputArray[end] = temp;

            start++;
            end--;
        }
    }

    public static String reverseWords(String input) {
        int start = 0;
        int length = input.length();
        int end = length - 1;
        char[] inputArray = input.toCharArray();
        reverseChars(inputArray, start, end);
        end = 0;
        while (end < length) {
            if (inputArray[end] != ' ') {
                start = end; // save the reversed start
                // go to the end of word
                while (end < length && inputArray[end] != ' ') {
                    end++;
                }
                end--;
                reverseChars(inputArray, start, end);
            }
            end++;
        }
        return String.copyValueOf(inputArray);
    }

    public static int getAsciiCode(char c) {
        return c;
    }

    public static boolean isValidNumber(String input) {
        int length = input.length();
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < length; i++) {
            int ascii = inputArray[i];
            if ((ascii >= 48 && ascii <= 57) || (ascii == 46)) {
            }/*
              * else if(decimalPtCount > 1) return false;
              */
        }
        return true;
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i),
                        str.substring(0, i) + str.substring(i + 1, n));
        }

    }

    // write a recursion method to insert "*" between each character in a string
    public static String insertStar(String input) {
        if (input == null) {
            return null;
        }
        String begin = String.valueOf(input.charAt(0));
        return prefixStar(begin, input.substring(1, input.length()));
    }

    private static String prefixStar(String prefix, String postfix) {
        if (postfix == null || postfix.length() == 0) {
            return prefix;
        }
        StringBuilder newPrefix = new StringBuilder(prefix);
        newPrefix.append("*");
        newPrefix.append(postfix.charAt(0));
        return prefixStar(newPrefix.toString(), postfix.substring(1, postfix.length()));
    }

    public static double power(double x, int n) {

        double pow = 1L;
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n % 2 == 0) {
            return power(x * x, n / 2);
        } else {
            return x * power(x * x, n / 2);
        }
    }

    public static double hoch(double basis, int exponent) {
        if (exponent == 0)
            return 1;
        else {
            double r = hoch(basis, exponent / 2);
            if (exponent % 2 < 0)
                return r * r / basis;
            else if (exponent % 2 > 0)
                return r * r * basis;
            else
                return r * r;
        }
    }

    public static int findMissing(int[] array) {
        int length = array.length;
        //int delta = (array[length - 1] - array[0]) / length;
        // or
        int delta = Math.min(array[1] - array[0], array[length - 1] - array[length - 2]);

        return findMissingWithBinary(array, 0, length - 1, delta);

    }

    // 2 4 6 8 12
    public static int findMissingWithBinary(int[] array, int low, int high, int delta) {
        if (high < low) {
            return -1;
        }
        int mid = (high + low) / 2;
        if (array[mid] - array[mid - 1] > delta) {
            return array[mid - 1] + delta;
        } else if (array[mid + 1] - array[mid] > delta) {
            return array[mid] + delta;
        } else if (array[mid] > array[low] + (mid - 1) * delta) {
            return findMissingWithBinary(array, low, mid - 1, delta);
        }
        return findMissingWithBinary(array, mid + 1, high, delta);
    }

    /*
     * public String lookandsay(int n){ if (n < 1) return "0"; String cur = "1"; for (int i = 1; i < n; i++){
     * StringBuilder sb = new StringBuilder(); int count = 1; int pos = 1;
     *
     * char c=cur.charAt(0);
     *
     * while(pos < cur.length()){ if (cur.charAt(pos) == c){ count ++; } else{ sb.append(count); sb.append(c); c =
     * cur.charAt(pos); count = 1; } pos++; } sb.append(count); sb.append(c); cur=sb.toString(); } return cur; }
     */
    // aaabbcccc
    // 1, 11, 21, 1211, 111221
    public static String compress(String input) {
        StringBuffer output = new StringBuffer();
        char[] inputChars = input.toCharArray();
        char last = inputChars[0];
        int count = 1;
        // abbbc
        for (int i = 1; i < inputChars.length; i++) {
            if (last == inputChars[i]) {
                count++;
            } else {
                output.append(last);
                output.append(count);
                last = inputChars[i];
                count = 1;
            }
        }
        output.append(last);
        output.append(count);
        return output.toString();
    }

    public static String[] say_what_you_see(String[] input_strings) {
        String[] outputStrings = null;
        if (input_strings != null) {
            outputStrings = new String[input_strings.length];
            for (int j = 0; j < input_strings.length; j++) {
                char[] array = input_strings[j].toCharArray();
                char last = array[0];
                StringBuffer output = new StringBuffer("");
                int count = 1;
                for (int i = 1; i < array.length; i++) {
                    if (last == array[i]) {
                        count++;
                    } else {
                        output.append(count);
                        output.append(last);
                        last = array[i];
                        count = 1;
                    }
                }
                output.append(count);
                output.append(last);
                outputStrings[j] = output.toString();
            }
        }
        return outputStrings;
    }

    // u n i t e d s t a t e s => e n a t e d s t i t u s
    // a l l i t e r a t i o n => o l l i t a r e t i a n
    public static String swapVowels(String input) {
        char[] inputArr = input.toCharArray();
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (isVowel(inputArr[start]) && isVowel(inputArr[end])) {
                swapChars(inputArr, start, end);
                start++;
                end--;
            } else if (!isVowel(inputArr[start])) {
                start++;
            } else if (!isVowel(inputArr[end])) {
                end--;
            }
        }
        return new String(inputArr);
    }

    public static String swapVowelsUsingSpace(String input) {
        char[] inputArray = input.toCharArray();
        Stack<Character> vowelStack = new Stack<>();

        for (int i = 0; i < inputArray.length; i++) {
            char c = inputArray[i];
            if (isVowel(c)) {
                vowelStack.push(c);
                inputArray[i] = '#';
            }
        }

        for (int i = 0; i < inputArray.length; i++) {
            char c = inputArray[i];
            if (c == '#') {
                inputArray[i] = vowelStack.pop();
            }
        }

        return new String(inputArray);
    }

    private static void swapChars(char[] input, int start, int end) {
        char temp = input[start];
        input[start] = input[end];
        input[end] = temp;

    }

    private static boolean isVowel(char c) {
        if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u')) {
            return true;
        }
        return false;
    }

    // apple => a3e
    public static String compressConsonants(String input) {
        StringBuilder sb = new StringBuilder("");
        int consonantCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (isVowel(currentChar)) {
                sb.append(consonantCount);
                sb.append(currentChar);
            } else {
                consonantCount++;
            }
        }

        return sb.toString();
    }

}
