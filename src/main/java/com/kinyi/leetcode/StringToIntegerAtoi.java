package com.kinyi.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @author Kinyi_Chan
 * @since 2019-09-18
 */
public class StringToIntegerAtoi {

    public static int myAtoi(String str) {
        Pattern pattern = Pattern.compile("^\\s*([+-]?\\d+)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String target = matcher.group(1);
            try {
                return Integer.parseInt(target);
            } catch (NumberFormatException e) {
                if (target.startsWith("-")) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        } else {
            return 0;
        }
    }

    public static int myAtoi2(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        long sum = 0;
        int first = 0, n = str.length();
        int flag = 1;
        if (str.charAt(0) == '+') {
            first++;
        } else if (str.charAt(0) == '-') {
            first++;
            flag = -1;
        }
        for (int i = first; i < n; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) sum * flag;
            }
            sum = 10 * sum + str.charAt(i) - '0';
            if (flag == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (flag == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) sum * flag;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(myAtoi("1534236469"));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(myAtoi2("1534236469"));
        System.out.println(System.nanoTime() - start);
    }
}
