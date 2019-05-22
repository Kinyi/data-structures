package com.kinyi.stack;

/**
 * @author Kinyi_Chan
 * @since 2019-05-19
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
