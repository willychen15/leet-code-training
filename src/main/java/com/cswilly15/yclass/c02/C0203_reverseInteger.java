package com.cswilly15.yclass.c02;

public class C0203_reverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseByString(-120));
        System.out.println(reverseByString(320));
        System.out.println(reverseByString(100));
        System.out.println(reverseByString(2147483647));

        System.out.println(reverseByModulo(-120));
        System.out.println(reverseByModulo(320));
        System.out.println(reverseByModulo(100));
        System.out.println(reverseByModulo(2147483647));
    }

    public static int reverseByString(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x *= -1;
        }

        String inputString = Integer.toString(x);
        String s = new StringBuilder(inputString).reverse().toString();

        int answer;

        // reverse() 完的結果可能會 overflow，parseInt() 會出問題
        try {
            // reverse() 完 120 => 021 ，parseInt() 會處理成有效整數，傳回 21
            answer = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }

        if (negative) {
            answer *= -1;
        }
        return answer;
    }

    public static int reverseByModulo(int x) {
        int answer = 0;
        while (x != 0) {
            // -2147483648 ~ 2147483647
            if (answer > 214748364 || answer < -214748364
                    || (answer == 214748364 && x % 10 > 7)
                    || (answer == -214748364 && x % 10 < -8)) {
                return 0;
            }
            answer = answer * 10 + x % 10;
            x /= 10;
        }
        return answer;
    }
}
