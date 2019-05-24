package com.kinyi.list;

/**
 * 虚拟头结点
 *
 * @author Kinyi_Chan
 * @since 2019-05-22
 */
public class DummyHeadLinkedList<E> {

    private class Node {
        private E e;
        private Node next;

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

    private Node dummyHead;
    private int size;

    public DummyHeadLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //在链表的index(0-based)位置添加新的元素e
    //在链表中使用index不是一个常用的操作, 仅做练习用：)
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("LinkedList add failed. index is illegal");
        }
        Node prev = dummyHead;
        //寻找index的上一个节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size--;
        return cur.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeEle(E e) {
//        Node cur = dummyHead.next;
//        for (int i = 0; i < size - 1; i++) {
//            if (cur.e.equals(e)) {
//                return remove(i);
//            }
//            cur = cur.next;
//        }
//        return null;
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node cur = prev.next;
            prev.next = cur.next;
            cur.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            sb.append(cur.e);
//            sb.append("->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur.e);
            sb.append("->");
        }
        sb.append("NULL");
        return sb.toString();
    }
}
