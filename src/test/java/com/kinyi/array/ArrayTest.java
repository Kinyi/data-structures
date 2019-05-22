package com.kinyi.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Kinyi_Chan
 * @since 2019-05-16
 */
public class ArrayTest {

    @Test
    public void toStringTest() {
        Array<Integer> array = new Array<>();
        for (int i = 1; i <= 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1, 100);
        System.out.println(array);
        array.addFirst(-1);
        System.out.println(array);
        System.out.println(array.get(0));
        array.removeLast();
        array.removeLast();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
    }
}