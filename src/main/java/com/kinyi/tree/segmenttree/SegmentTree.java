package com.kinyi.tree.segmenttree;

/**
 * 线段树
 *
 * @author Kinyi_Chan
 * @since 2019-07-29
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        tree = (E[]) new Object[4 * arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];

        }
    }

    private void buildSegmentTree(int index, int l, int r) {

    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("illegal index");
        }
        return data[index];
    }

    private int leftChild(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("illegal index");
        }
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("illegal index");
        }
        return index * 2 + 2;
    }
}
