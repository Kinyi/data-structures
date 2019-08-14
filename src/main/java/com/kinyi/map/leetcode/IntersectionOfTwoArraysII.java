package com.kinyi.map.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 350. 两个数组的交集 II
 *
 * @author Kinyi_Chan
 * @since 2019-06-06
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                Integer integer = map.get(i);
                if (integer == 1) {
                    map.remove(i);
                } else {
                    map.put(i, integer - 1);
                }
            }
        }
        int[] rst = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rst[i] = list.get(i);
        }
        return rst;
    }
}
