package com.kinyi.leetcode;

/**
 * 203. 移除链表元素
 *
 * @author Kinyi_Chan
 * @since 2019-05-24
 */
public class RemoveLinkedListElements {

    class Solution {

        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val) {
                ListNode cur = head;
                head = head.next;
                cur.next = null;
            }
            if (head == null) {
                return null;
            }
            ListNode prev = head;
            while (prev.next != null) {
                if (prev.next.val == val) {
                    ListNode removeNode = prev.next;
                    prev.next = removeNode.next;
                    removeNode.next = null;
                } else {
                    prev = prev.next;
                }
            }
            return head;
        }
    }

    /**
     * 使用虚拟头结点
     */
    class Solution2 {

        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode prev = dummyHead;
            while (prev.next != null) {
                if (prev.next.val == val) {
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            return dummyHead.next;
        }
    }

    class Solution3 {

        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode subListNode = removeElements(head.next, val);
            if (head.val == val) {
                return subListNode;
            } else {
                head.next = subListNode;
                return head;
            }
        }
    }

    /**
     * 失败尝试，不能使用后一个节点覆盖当前相等节点，因为当最后一个节点也相等时，无法删除
     */
    class Solution_fail {
        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            if (head == null) {
                return null;
            }
            ListNode nextNode = head.next;
            while (nextNode != null) {
                if (nextNode.val == val) {
                    if (nextNode.next != null) {
                        nextNode.val = nextNode.next.val;
                        nextNode.next = nextNode.next.next;
                    } else {
                        nextNode = null;
                    }
                } else {
                    nextNode = nextNode.next;
                }
            }
            return head;
        }
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

