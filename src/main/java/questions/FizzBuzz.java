package questions;

public class FizzBuzz {
    public static void main(String[] args) {
        //int input = 223;
        //int input = 9;
        //int input = 10;
        int input = 15;

        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.calculate(input));

    }

    private String calculate(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "fizzbuzz";
        } else if (number % 3 == 0) {
            return "fizz";
        } else if (number % 5 == 0) {
            return "buzz";
        } else {
            return new Integer(number).toString();
        }
    }
}
