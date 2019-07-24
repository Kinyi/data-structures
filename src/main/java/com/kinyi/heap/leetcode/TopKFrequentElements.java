package com.kinyi.heap.leetcode;

import java.util.*;

/**
 * 347. 前K个高频元素
 *
 * @author Kinyi_Chan
 * @since 2019-07-24
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(priorityQueue.peek()) < map.get(key)) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        return new ArrayList<>(priorityQueue);
    }
}
