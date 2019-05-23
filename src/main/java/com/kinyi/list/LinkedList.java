package com.kinyi.list;

/**
 * @author Kinyi_Chan
 * @since 2019-05-22
 */
public class LinkedList<E> {

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

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("LinkedList add failed. index is illegal");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            //我的理解写法
//            Node prev = head;
//            for (int i = 1; i < size; i++) {
//                if (i == index) {
//                    prev.next = new Node(e, prev.next);
//                    size++;
//                    return;
//                } else {
//                    prev = prev.next;
//                }
//            }
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            Node next = prev.next;
//            Node tmp = new Node(e, next);
//            prev.next = tmp;
            //上面👆三句等价于  ==>  下面👇这一句
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }
}
