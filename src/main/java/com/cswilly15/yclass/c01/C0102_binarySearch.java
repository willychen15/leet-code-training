package com.cswilly15.yclass.c01;

public class C0102_binarySearch {
    public static void main(String[] args) {
        int[] a1 = {12, 15, 25, 31, 32, 40, 45, 55};
        System.out.println(binarySearch(a1, 10));
        System.out.println(binarySearch(a1, 12));
        System.out.println(binarySearch(a1, 15));
        System.out.println(binarySearch(a1, 25));
        System.out.println(binarySearch(a1, 31));
        System.out.println(binarySearch(a1, 32));
        System.out.println(binarySearch(a1, 40));
        System.out.println(binarySearch(a1, 45));
        System.out.println(binarySearch(a1, 55));
        System.out.println(binarySearch(a1, 66));
    }

    /*
     * sortedArray[]：要搜尋的陣列(已排序)
     * target：要搜尋的目標
     * sortedArray 裡存在要搜尋的 target，return 在 sortedArray 裡的 index，不存在則 return -1
     * */
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

}
