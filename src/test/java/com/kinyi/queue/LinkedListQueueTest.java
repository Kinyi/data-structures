package com.kinyi.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Kinyi_Chan
 * @since 2019-05-23
 */
public class LinkedListQueueTest {

    @Test
    public void test() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}