package com.kinyi.leetcode;

/**
 * 5. 最长回文子串
 *
 * @author Kinyi_Chan
 * @since 2019-09-11
 */
public class LongestPalindromicSubstring {

    /**
     * 动态规划
     *
     * @param input
     * @return
     */
    public String longestPalindrome(String input) {
        int len = input.length();
        if (len == 0) {
            return input;
        }
        boolean[][] dp = new boolean[len][len];
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (input.charAt(r) == input.charAt(l)
                        // 挨着的情况       两数隔开的情况
                        && (r - l == 1 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l > end - start) {
                        start = l;
                        end = r;
                    }
                } else {
                    dp[l][r] = false;
                }
            }
        }
        return input.substring(start, end + 1);
    }

    /**
     * Manacher算法
     *
     * @param input
     * @return
     */
    public String longestPalindrome2(String input) {
        StringBuilder s = new StringBuilder("#");
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            s.append(c).append("#");
        }
        int id = 0;
        int maxRight = 0;
        int resCenter = 0;
        int resLength = 0;
        String str = s.toString();
        int length = str.length();
        int[] r = new int[length];
        for (int i = 1; i < length - 1; i++) {
            r[i] = maxRight > i ? Math.min(r[2 * id - i], maxRight - i) : 1;
            while (i - r[i] >= 0 && i + r[i] < length && str.charAt(i + r[i]) == str.charAt(i - r[i])) {
                r[i]++;
            }
            r[i]--;
            if (i + r[i] > maxRight) {
                maxRight = i + r[i];
                id = i;
            }
            if (r[i] > resLength) {
                resLength = r[i];
                resCenter = i;
            }
        }
        return input.substring((resCenter - resLength) / 2, (resCenter + resLength) / 2);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(new LongestPalindromicSubstring().longestPalindrome2("babad"));
        System.out.println(System.nanoTime() - start);
    }
}
