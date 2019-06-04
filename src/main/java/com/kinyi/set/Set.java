package com.kinyi.set;

/**
 * @author Kinyi_Chan
 * @since 2019-06-04
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
