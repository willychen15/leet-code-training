package com.cswilly15.yclass.c03;

import java.util.Arrays;

public class C0302_twoSum2 {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(twoSum2ByBinarySearch(a1, 6)));
        System.out.println(Arrays.toString(twoSum2ByPointers(a1, 6)));
    }

    public static int[] twoSum2ByBinarySearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int j = binarySearch(nums, target - x);
            if (j != -1) {
                return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("No solution!!");
    }

    public static int binarySearch(int[] sortedArray, int target) {
        int low = 0;
        int high = sortedArray.length - 1;
        int middle;

        while (low <= high) {
            middle = (low + high) >>> 1;  // 使用無符號右移
            if (target == sortedArray[middle]) {
                return middle;
            } else if (sortedArray[middle] < target) {
                low = middle + 1;
            } else if (target < sortedArray[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static int[] twoSum2ByPointers(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (j > i) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("No solution!!");
    }
}
