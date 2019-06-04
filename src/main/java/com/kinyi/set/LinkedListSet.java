package com.kinyi.set;

import com.kinyi.list.DummyHeadLinkedList;

/**
 * @author Kinyi_Chan
 * @since 2019-06-04
 */
public class LinkedListSet<E> implements Set<E> {
    private DummyHeadLinkedList<E> list;

    public LinkedListSet() {
        list = new DummyHeadLinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeEle(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
