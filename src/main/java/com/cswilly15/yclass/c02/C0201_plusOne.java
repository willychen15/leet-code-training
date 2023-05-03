package com.cswilly15.yclass.c02;

import java.util.Arrays;

public class C0201_plusOne {
    public static void main(String[] args) {
        int[] a1 = {9, 9};
        System.out.println(Arrays.toString(plusOne(a1)));

        int[] a2 = {5, 9, 8};
        System.out.println(Arrays.toString(plusOne(a2)));

        int[] a3 = {5, 9, 9};
        System.out.println(Arrays.toString(plusOne(a3)));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit < 9) {
                digits[i] = digit + 1;
                return digits;
            } else {
                // digit == 9
                digits[i] = 0;
            }
        }

        // [9, 9] -> [1, 0, 0]
        int[] answer = new int[digits.length + 1];
        answer[0] = 1;
        return answer;
    }
}
