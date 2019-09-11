package com.kinyi.leetcode;

/**
 * 3. 无重复字符的最长子串
 *
 * @author Kinyi_Chan
 * @since 2019-09-09
 */
public class LongestSubstringWithoutRepeatingCharacter {

    @Deprecated
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        int front = 0;
        for (int tail = 1; tail < s.length(); tail++) {
            String tailChar = s.substring(tail, tail + 1);
            String substring = s.substring(front, tail);
            if (substring.contains(tailChar)) {
                int tmp = tail - front;
                maxLength = maxLength < tmp ? tmp : maxLength;
                front = substring.lastIndexOf(tailChar) + front + 1;
            } else if (tail == s.length() - 1) {
                int tmp = tail + 1 - front;
                maxLength = maxLength < tmp ? tmp : maxLength;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int maxLength = 1;
        int front = 0;
        for (int tail = 1; tail < charArray.length; tail++) {
            String substring = s.substring(front, tail);
            if (substring.indexOf(charArray[tail]) != -1) {
                int tmp = tail - front;
                maxLength = maxLength < tmp ? tmp : maxLength;
                front = substring.lastIndexOf(charArray[tail]) + front + 1;
            } else if (tail == s.length() - 1) {
                int tmp = tail + 1 - front;
                maxLength = maxLength < tmp ? tmp : maxLength;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] charArr = s.toCharArray();
        if (charArr.length == 0) {
            return 0;
        }
        int maxLength = 0;
        int baseIndex = 0;
        int i;
        //i从第二个元素开始
        for (i = baseIndex + 1; i < charArr.length; i++) {
            //j从base开始，从前往后找，与第i个相同的元素，并且计算长度
            for (int j = baseIndex; j < i; j++) {
                //如果找到相同元素，base直接跳到当前元素下一个
                if (charArr[j] == charArr[i]) {
                    maxLength = (i - baseIndex) > maxLength ? (i - baseIndex) : maxLength;
                    baseIndex = j + 1;
                    break;
                }
            }
        }
        //全部遍历后还要再计算一次，如果直到最后一位还没有重复元素的情况
        maxLength = (i - baseIndex) > maxLength ? (i - baseIndex) : maxLength;
        return maxLength;
    }

    public int lengthOfLongestSubstring3(String s) {
        int[] freq = new int[256];
        // sliding window: s[l...r]
        int l = 0, r = -1;
        int res = 0;
        while (r + 1 < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else {//freq[s[r+1]] == 1
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring("dabcefgd"));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring1("dabcefgd"));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring2("dabcefgd"));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring3("dabcefgd"));
        System.out.println(System.nanoTime() - start);
    }
}
