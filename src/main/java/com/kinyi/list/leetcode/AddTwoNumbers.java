package com.kinyi.list.leetcode;

/**
 * 2. 两数相加
 *
 * 思路: 两数对应位相加, 逢10高位进1
 * 做法: sum * 10 + reverse(对应位之和)
 *
 * @author Kinyi_Chan
 * @since 2019-06-03
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode rst = null;
        ListNode cur = null;
        do {
            int i = sum * 10 + reverse((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val));
            if (rst == null) {
                rst = cur = new ListNode(i / 10);
            } else {
                cur.next = new ListNode(i / 10 == 10 ? 0 : i / 10);
                cur = cur.next;
            }
            sum = i / 10 == 10 ? 1 : i % 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        } while (l1 != null || l2 != null);
        if (sum != 0) {
            cur.next = new ListNode(sum);
        }
        return rst;
    }

    private int reverse(int ini) {
        if (ini > 99 || ini < 0) {
            throw new IllegalArgumentException("illegal");
        }
        return ini / 10 + ini % 10 * 10;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//        System.out.println(addTwoNumbers.reverse(15));

        ListNode a = new ListNode(1);
//        a.next = new ListNode(8);
//        a.next.next = new ListNode(3);
        ListNode b = new ListNode(9);
        b.next = new ListNode(9);
//        b.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers.addTwoNumbers(a, b);
        System.out.println();
    }

}
