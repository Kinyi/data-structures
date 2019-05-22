package com.kinyi.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Kinyi_Chan
 * @since 2019-05-21
 */
public class LoopQueueTest {

    @Test
    public void test() {
        LoopQueue<Integer> queue = new LoopQueue<>();
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