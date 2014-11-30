package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://java67.blogspot.ca/2013/01/10-programming-questions-and-exercises.html
 */
public class Numbers {

    public boolean evenOrOdd(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }

        return number % 2 == 0;
    }

    public boolean isPrime(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }

        int sqRoot = (int) Math.round(Math.sqrt(number));
        int until = sqRoot + 1;
        int i = 2;

        while (i < until) {
            if (number % i == 0) {
                return false;
            }

            i++;
        }

        return true;
    }

    public boolean isPalindrome(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }

        String strNumber = Integer.toString(number);
        String palindrome = new String();

        for (int i = strNumber.length() - 1; i >= 0; i--) {
            palindrome += strNumber.charAt(i);
        }

        return palindrome.equals(strNumber);
    }

    public boolean isArmstrong(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }

        String strNumber = Integer.toString(number);
        int armStrong = 0;
        for (int i = 0; i < strNumber.length(); i++) {
            int digit = Integer.parseInt(strNumber.substring(i, i + 1));
            armStrong += digit * digit * digit;
        }

        return armStrong == number;
    }

    public boolean isBinary(int number) {
        int digit;
        while (true) {
            if (number > 9) {
                digit = number % 10;
                number = number / 10;
            } else {
                digit = number;
            }

            if (digit > 1) {
                return false;
            }

            if (digit == number) {
                return true;
            }
        }
    }

    public int findMissingNumber(int[] numbers) {
        List<Integer> master = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        for (int i = 0; i < numbers.length; i++) {
            master.remove(new Integer(numbers[i]));
        }

        return master.get(0);
    }

}
