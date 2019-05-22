package com.kinyi.array;

/**
 * @author Kinyi_Chan
 * @since 2019-05-16
 */
public class Array<E> {

    /**
     * 数组实际大小
     */
    private int size;
    private E[] data;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组头部添加一个新元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向数组末尾添加一个新元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 指定索引位置添加一个新元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. Require index >= 0 and index <= size");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. Index is illegal.");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引, 如果不存在元素e, 则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. Index is illegal.");
        }
        E rst = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //loitering objects
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return rst;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder rst = new StringBuilder();
        rst.append(String.format("Array: size = %d, capacity = %d%n", size, data.length));
        rst.append("[");
        for (int i = 0; i < size; i++) {
            rst.append(data[i]);
            if (i != size - 1) {
                rst.append(", ");
            }
        }
        rst.append("]");
        return rst.toString();
    }

    /**
     * 数组容量改变
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
