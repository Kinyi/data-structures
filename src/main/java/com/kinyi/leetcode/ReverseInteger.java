package com.kinyi.leetcode;

/**
 * 7. 整数反转
 *
 * @author Kinyi_Chan
 * @since 2019-09-17
 */
public class ReverseInteger {

    public static int reverse(int x) {
        int index = 0;
        int[] arr = new int[32];
        boolean nagative = x < 0;
        x = Math.abs(x);
        while (x > 0) {
            arr[index++] = x % 10;
            x = x / 10;
        }
        int rst = 0;
        int copyIndex = index;
        for (int i = 0; i < index; i++) {
            rst += (int) (Math.pow(10, --copyIndex) * arr[i]);
        }
        if (rst < 0) {
            return 0;
        }
        return nagative ? rst * -1 : rst;
    }

    public static int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(reverse(1534236469));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(reverse2(1534236469));
        System.out.println(System.nanoTime() - start);
    }
}
