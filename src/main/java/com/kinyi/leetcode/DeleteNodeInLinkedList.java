package com.kinyi.leetcode;

/**
 *237. 删除链表中的节点
 *
 * @author Kinyi_Chan
 * @since 2019-05-27
 */
public class DeleteNodeInLinkedList {
    ListNode head;

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

}
