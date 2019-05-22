package com.kinyi.queue;

/**
 * @author Kinyi_Chan
 * @since 2019-05-21
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;

    private int front;
    private int tail;
    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        front = tail = 0;
        size = 0;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("LoopQueue dequeue failed. Empty queue");
        }
        E rst = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getCapacity() / 4 == size && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return rst;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("LoopQueue getFront failed. Empty queue");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
//        return size == 0;
        return front == tail;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder rst = new StringBuilder();
        rst.append(String.format("LoopQueue: size = %d, capacity = %d%n", size, getCapacity()));
        rst.append("front [");
        for (int i = front; i < front + size; i++) {
            rst.append(data[i % data.length]);
            if ((i + 1) % data.length != tail) {
                rst.append(", ");
            }
        }
        //另外一种遍历方法
//        for (int i = front; i != tail; i = (i + 1) % data.length) {
//            rst.append(data[i]);
//            if ((i + 1) % data.length != tail) {
//                rst.append(", ");
//            }
//        }
        rst.append("] tail");
        return rst.toString();
    }
}
