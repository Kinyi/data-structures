package com.kinyi.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Kinyi_Chan
 * @since 2019-05-23
 */
public class DummyHeadLinkedListTest {

    @Test
    public void test() {
        DummyHeadLinkedList<Integer> list = new DummyHeadLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
            System.out.println(list);
        }
        list.add(2, 666);
        System.out.println(list);
    }

    @Test
    public void testNull() {
        System.out.println("1".equals(null));
        System.out.println(new Node().e.equals(1));
    }

    public class Node{
        private Integer e;

        public Node(Integer e) {
            this.e = e;
        }

        public Node() {
            this.e = null;
        }
    }
}