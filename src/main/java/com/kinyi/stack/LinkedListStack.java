package com.kinyi.stack;

import com.kinyi.list.DummyHeadLinkedList;

/**
 * @author Kinyi_Chan
 * @since 2019-05-23
 */
public class LinkedListStack<E> implements Stack<E> {

    private DummyHeadLinkedList<E> list;

    public LinkedListStack() {
        this.list = new DummyHeadLinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack: top " + list;
    }
}
