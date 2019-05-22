package com.kinyi.queue;

/**
 * @author Kinyi_Chan
 * @since 2019-05-20
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    /**
     * 查看队首元素
     * @return
     */
    E getFront();

    int getSize();

    boolean isEmpty();
}
