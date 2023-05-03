package com.cswilly15.yclass.c01;

import java.util.Arrays;

public class C0103_permute {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        permute(a1, 0);

        int[] a2 = {1, 2, 3, 4};
        permute(a2, 0);
    }

    /*
     * intArray[]：要排列的陣列
     * start：每次在排列時，當下要固定下來的數字的 index
     * */
    public static void permute(int[] intArray, int start) {
        for (int i = start; i < intArray.length; i++) {
            // 一開始做 SWAP，把 start 和 i 這兩個 index 裡面的內容互換
            int temp = intArray[start];
            intArray[start] = intArray[i];
            intArray[i] = temp;

            permute(intArray, start + 1);

            // 做完permute() 後要還原，所以在做一次 SWAP
            intArray[i] = intArray[start];
            intArray[start] = temp;
        }
        if (start == intArray.length) {
            System.out.println(Arrays.toString(intArray));
        }
    }
}
