package com.kinyi.explore.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * @author Kinyi_Chan
 * @since 2019-08-08
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
