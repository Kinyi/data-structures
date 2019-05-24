package com.kinyi.queue;

/**
 * @author Kinyi_Chan
 * @since 2019-05-23
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        Node lastNode = new Node(e);
        if (tail != null) {
            tail.next = lastNode;
        } else {
            head = lastNode;
        }
        tail = lastNode;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        Node rstNode = head;
        head = head.next;
        rstNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return rstNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue top ");
        Node cur = head;
        while (cur != null) {
            sb.append(cur).append("->");
            cur = cur.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }
}
