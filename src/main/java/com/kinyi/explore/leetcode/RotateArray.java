package com.kinyi.explore.leetcode;

/**
 * 189. 旋转数组
 *
 * @author Kinyi_Chan
 * @since 2019-08-08
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        while (k-- > 0) {
            int last = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = last;
        }
    }
}
