package com.cswilly15.yclass.c02;

public class C0202_pow {
    public static void main(String[] args) {
        System.out.println(pow(2, 10));
        System.out.println(pow(2, -10));
        System.out.println(pow(2, 0));

        System.out.println(optimizedPow(2, 10));
        System.out.println(optimizedPow(2, -10));
        System.out.println(optimizedPow(2, 0));
    }

    public static double pow(double x, int n) {
        double answer = 1;
        boolean negative = false;

        // n 已經是 int 最小值(-2147483648~2147483647)，n * (-1) 會有 overflow 的問題
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            negative = true;
            n *= -1;
        }

        for (int i = 0; i < n; i++) {
            answer *= x;
        }
        if (negative) {
            answer = 1 / answer;
        }
        return answer;
    }

    public static double optimizedPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n *= -1;
            x = 1 / x;
        }

        if (n % 2 == 0) {
            return optimizedPow(x * x, n / 2);
        } else {
            return x * optimizedPow(x * x, n / 2);
        }
    }
}
