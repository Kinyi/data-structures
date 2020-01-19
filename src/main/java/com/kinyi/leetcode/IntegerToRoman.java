package com.kinyi.leetcode;

import java.util.Arrays;

/**
 * 12. 整数转罗马数字
 *
 * @author Kinyi_Chan
 * @since 2019-09-20
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        String[] one = {"I", "X", "C", "M", ""};
        String[] five = {"V", "L", "D", ""};
        for (int i = 3; i >= 0; i--) {
            int b = (int) Math.pow(10, i);
            if (num >= b) {
                int x = num / b;
                res.append(rome(x, one[i], five[i], one[i + 1]));
                num %= b;
            }
        }
        return res.toString();
    }

    private String rome(int x, String one, String five, String ten) {
        if (x <= 3) {
            return generateDuplicateChar(x, one.charAt(0));
        } else if (x == 4) {
            return one + five;
        } else if (x <= 8) {
            return five + generateDuplicateChar(x - 5, one.charAt(0));
        }
        // x == 9
        return one + ten;
    }

    private String generateDuplicateChar(int times, char c) {
        char[] chars = new char[times];
        Arrays.fill(chars, c);
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(135));
    }
}
