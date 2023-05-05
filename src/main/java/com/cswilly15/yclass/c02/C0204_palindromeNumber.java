package com.cswilly15.yclass.c02;

public class C0204_palindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(123456));
        System.out.println(isPalindromeNumber(12321));
        System.out.println(isPalindromeNumber(-12321));
        System.out.println(isPalindromeNumber(125521));
    }

    public static boolean isPalindromeNumber(int x) {
        if (x < 0) {
            return false;
        }

        int divisior = 1;
        // 1234 / 1000 = 1
        while (x / divisior >= 10) {
            divisior *= 10;
        }

        while (x != 0) {
            int leftDigit = x / divisior;
            int rightDigit = x % 10;
            if (leftDigit != rightDigit) {
                return false;
            }

            // x = 12321 divisor = 10000
            // (x % divisor) = 2321
            // 2321 / 10 = 232
            x = (x % divisior) / 10;

            divisior /= 100;
        }
        return true;
    }

}
