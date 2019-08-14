package com.kinyi.explore.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 66. 加一
 *
 * @author Kinyi_Chan
 * @since 2019-08-13
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();
        int forward = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + forward;
            forward = sum / 10;
            list.add(sum % 10);
        }
        if (forward != 0) {
            list.add(forward);
        }
        int size = list.size();
        int[] rst = new int[size];
        for (int i = 0; i < size; i++) {
            rst[i] = list.pollLast();
        }
        return rst;
    }

    public static int[] plusOne2(int[] digits) {
        int k = digits.length;
        for (int i = k - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[k + 1];
        digits[0] = 1;
        return digits;

    }


    public static void main(String[] args) {
//        System.out.println(Math.pow(2, 10));
        System.out.println(Arrays.toString(plusOne2(new int[]{9, 9, 9})));
    }
}
