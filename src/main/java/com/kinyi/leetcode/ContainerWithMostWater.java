package com.kinyi.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 11. 盛最多水的容器
 *
 * @author Kinyi_Chan
 * @since 2019-09-19
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int rst = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tmp = (j - i) * Math.min(height[i], height[j]);
                if (tmp > rst) {
                    rst = tmp;
                }
            }
        }
        return rst;
    }

    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 3, 5, 6, 2, 4}));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(new ContainerWithMostWater().maxArea2(new int[]{1, 8, 3, 5, 6, 2, 4}));
        System.out.println(System.nanoTime() - start);

        List<String> list = new LinkedList<>();
        list.add("kinyi");
        list.add("kinyi");
        Map<String, String> collect = list.stream().collect(Collectors.toMap(x -> x, x -> x, (v1, v2) -> v1));
        System.out.println(collect);
    }
}
