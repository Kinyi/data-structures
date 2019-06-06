package com.kinyi.set.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 349. 两个数组的交集
 *
 * @author Kinyi_Chan
 * @since 2019-06-06
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }
        int[] rst = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rst[i] = list.get(i);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};
        int[] intersection = new IntersectionOfTwoArrays().intersection(num1, num2);
        System.out.println();
    }
}
