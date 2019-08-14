package com.kinyi.explore.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 350. 两个数组的交集 II
 * <p>
 * 错误❌解法
 *
 * @author Kinyi_Chan
 * @since 2019-08-12
 */
public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i : nums1) {
            l1.add(i);
        }
        for (int i : nums2) {
            l2.add(i);
        }
        l1.retainAll(l2);
        int[] rst = new int[l1.size()];
        for (int i = 0; i < l1.size(); i++) {
            rst[i] = l1.get(i);
        }
        return rst;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2};
//        int[] intersect = intersect(nums1, nums2);
//        System.out.println(Arrays.asList(intersect));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 1) {
                    break;
                }
                System.out.println("i: " + i + ", j: " + j);
            }
        }
    }
}
