package main.java.string;

public class StringManipulation {

	public static void main(String[] args) {
	
		char[] a = new char[] {0, 0 ,0 , 0, 0};

		System.out.println("String related functions");

		boolean flag = hasUniqueChars("shra");
		System.out.println(flag);

		flag = hasUniqueChars("abc101");
		System.out.println(flag);

		String input = "My name is shraddha.";
		char[] inputArr = input.toCharArray();
		reverseChars(inputArr, 0, input.length() - 1);
		System.out.println(inputArr);

		input = reverseWords(input);
		System.out.println(input);

		System.out.println(getAsciiCode('.'));
		System.out.println(getAsciiCode('0'));
		System.out.println(getAsciiCode('9'));

		System.out.println(isValidNumber("127875.55"));
		System.out.println(isValidNumber("127875.55a"));

		//double ans = power(2,3);		
		double ans = power(2,4);	
		ans = hoch(2,3);
		System.out.println(ans);
	}

	public static boolean hasUniqueChars(String input) {

		if (input.length() > 256) {
			return false;
		}

		boolean[] charSet = new boolean[256];

		for (int i = 0; i < input.length(); i++) {
			int asciiValue = input.charAt(i);
			if (charSet[asciiValue] == true) {
				return false;
			} else {
				charSet[asciiValue] = true;
			}
		}
		return true;
	}

	public static void reverseChars(char[] inputArray, int start, int end) {

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
				start = end; //save the reversed start
				//go to the end of word
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
				continue;
			}/* else if(decimalPtCount > 1)
				return false;*/
		}
		return true;
	}
	
	
	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
		}
	}
	
	// u n i t e d  s t a t e s
	/*public staic void swapVowels(String input) {
		char[] inputArr = input.toChatArray();
		int start = 0;
		int end = input.length() -1;
		while (start < end) {
			if ( isVowel(inputArr[start]) && isVowel(inputArr[end]) ) {
				swapChars(inputArr[start], inputArr[end]);
				start ++;
				end --;
			} else if (!isVowel(inputArr[start])) {
				start++;
			} else if (!isVowel(inputArr[end])) {
				end--;
			}
		}
		return String.copyValueOf(inputArr);
	
	} */
	
	public static double power(double x, int n) {

		double pow = 1L;
		if(n==0)
			return 1;
		if (n == 1)
			return x;
		if(n%2==0){
			return power(x*x, n / 2);
		}
		else{
			return x * power(x*x, n/2);
		}
	}
	
	public static double hoch(double basis, int exponent){
		if(exponent == 0)
			return 1;
		else{
			double r = hoch(basis, exponent/2);
			if(exponent % 2 < 0)
				return r * r / basis;
			else if(exponent % 2 > 0)
				return r * r * basis;
			else
				return r * r;
		}	
	}
}