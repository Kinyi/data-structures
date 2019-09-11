package com.kinyi.explore.leetcode;

import java.util.Arrays;

/**
 * 1. 两数之和
 *
 * @author Kinyi_Chan
 * @since 2019-08-14
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int max = 2047;
        int temp;
        int[] test = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            temp = (target - nums[i]) & max;
            if (test[temp] != 0) {
                return new int[]{test[temp] - 1, i};
            }
            test[nums[i] & max] = i + 1;
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] arr = twoSum2(new int[]{5, 4101, 5, 1}, 10);
        System.out.println("consume: " + (System.nanoTime() - start));
        System.out.println(Arrays.toString(arr));
    }
}
