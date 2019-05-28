package com.kinyi.leetcode.recursive;

/**
 * @author Kinyi_Chan
 * @since 2019-05-24
 */
public class Sum {

    public int sum(int[] arr) {
        return sum(arr, 0);
    }

    private int sum(int[] arr, int left) {
        if (left == arr.length) {
            return 0;
        }
        return arr[left] + sum(arr, left + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(new Sum().sum(arr));
    }
}
