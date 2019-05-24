package com.kinyi.stack;

import com.kinyi.queue.ArrayQueue;
import com.kinyi.queue.LoopQueue;
import com.kinyi.queue.Queue;
import org.junit.Test;

import java.util.Random;

/**
 * @author Kinyi_Chan
 * @since 2019-05-23
 */
public class LinkedListStackTest {

    @Test
    public void compareTest() {
        int opCount = 1000000;
        System.out.println(testStack(new ArrayStack<>(), opCount));
        System.out.println(testStack(new LinkedListStack<>(), opCount));
    }

    //其实这个时间复杂度比较复杂, 因为LinkedListStack中包含更多的new操作, 需要在内存寻找空间生成对象, 这个操作也比较耗时
    private double testStack(Stack<Integer> stack, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        return (System.nanoTime() - start) / 1000000000.0;
    }
}