package com.kinyi.explore.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kinyi_Chan
 * @since 2020-03-04
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(26);
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            int value = map.getOrDefault(c, 0) - 1;
            if (value < 0) {
                return false;
            }
            map.put(c, value);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
        System.out.println(isAnagram2("rat", "car"));
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (arr[c - 'a']-- <= 0) {
                return false;
            }
        }
        return true;
    }
}
