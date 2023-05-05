package com.cswilly15.yclass.c03;

import java.util.Arrays;
import java.util.HashMap;

public class C0301_twoSum {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4};

        System.out.println(Arrays.toString(twoSum(a1, 7)));
        System.out.println(Arrays.toString(twoSumByHashMap(a1, 3)));

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution!!");
    }

    public static int[] twoSumByHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // Array的值為 HashMap 的 Key，index 為 value
        // [2, 7, 4, 3]
        // {
        //    2: 0,
        //    7: 1,
        //    4: 2,
        //    3: 3
        // }

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (hashMap.containsKey(target - x)) {
                return new int[]{hashMap.get(target - x), i};
            }
            hashMap.put(x, i);
        }

        throw new IllegalArgumentException("No solution!!");
    }
}
