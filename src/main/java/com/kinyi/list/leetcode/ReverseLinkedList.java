package com.kinyi.list.leetcode;

/**
 * @author Kinyi_Chan
 * @since 2019-05-27
 */
public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode reverseList = reverseList(head.next);
            if (reverseList == null) {
                return head;
            }
            head.next.next = head;
            head.next = null;
            return reverseList;
        }
    }
}
