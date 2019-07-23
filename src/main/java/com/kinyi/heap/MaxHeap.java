package com.kinyi.heap;

import com.kinyi.array.Array;

import java.util.Random;

/**
 * 最大堆
 *
 * @author Kinyi_Chan
 * @since 2019-07-22
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap() {
        this.data = new Array<>();
    }

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    /**
     * heapify
     *
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        //从最后一个叶子节点的父节点开始siftDown
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 取出最大元素 放入新元素
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E rst = findMax();
        data.set(0, e);
        siftDown(0);
        return rst;
    }

    /**
     * 判断堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回堆中的元素个数
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 返回完全二叉树的数组表示中, 一个索引所表示的元素的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中, 一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中, 一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(size() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(parent(index), index);
            index = parent(index);
        }
    }

    /**
     * 看堆中的最大元素
     *
     * @return
     */
    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("array is empty");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {
        E rst = findMax();
        data.set(0, data.get(size() - 1));
        data.removeLast();
        siftDown(0);
        return rst;
    }

    private void siftDown(int k) {
        while (leftChild(k) < size()) {
            int j = leftChild(k);
            if (rightChild(k) < size() && data.get(rightChild(k)).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        Integer[] rst = new Integer[n];
        for (int i = 0; i < n; i++) {
            rst[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (rst[i - 1] < rst[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");
    }
}
