package com.kinyi.queue;

import org.junit.Test;

import java.util.Random;

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

    @Test
    public void compareTest() {
//        System.out.println(testQueue(new ArrayQueue<>(), 100000));
        System.out.println(testQueue(new LoopQueue<>(), 100000));
        System.out.println(testQueue(new LinkedListQueue<>(), 100000));
    }

    private double testQueue(Queue<Integer> queue, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        return (System.nanoTime() - start) /1000000000.0;
    }
}