package com.kinyi.explore.leetcode;

import java.util.Arrays;

/**
 * 283. 移动零
 *
 * @author Kinyi_Chan
 * @since 2019-08-13
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int zeroCount = 0;
        int length = nums.length;
        for (int i = 0; i < length; ) {
            if (nums[i] == 0) {
                zeroCount++;
                i++;
            } else if (zeroCount != 0) {
//                for (int j = i; j < length; j++) {
//                    nums[j - zeroCount] = nums[j];
//                }
                System.arraycopy(nums, i, nums, i - zeroCount, length - i);
                for (int j = length - zeroCount; j < length; j++) {
                    nums[j] = 0;
                }
                i = i - zeroCount + 1;
                zeroCount = 0;
            } else {
                i++;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        //i:插入位置下标 ; j:查找位置下标
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        //将后面的位置补0
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
