package com.kinyi.explore.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 *
 * @author Kinyi_Chan
 * @since 2019-08-10
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 数字相同异或为0, 数字与0异或为该数字
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp = tmp ^ nums[i];
        }
        return tmp;
    }

    /**
     * 1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，其它均只出现
     * 一次。每个数组元素只能访问一次，设计一个算法，将它找出来；不用辅助存储空
     * 间，能否设计一个算法实现？
     * <p>
     * 解法:
     * 1^2^...^n^...^n^...^1000 = 1^2^...^1000^(n^n)= 1^2^...^1000^0 = 1^2^...^1000（即序列中除了n的所有数的异或）。
     * 令1^2^...^1000（序列中不包含n）的结果为T
     * 则1^2^...^1000（序列中包含n）的结果就是T^n。
     * T^(T^n)=n。
     * 所以，将所有的数全部异或，得到的结果与1^2^3^...^1000的结果进行异或，得到的结果就是重复数
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 2 ^ 1 ^ 2 ^ 3 ^ 4 ^ 5);
    }
}
