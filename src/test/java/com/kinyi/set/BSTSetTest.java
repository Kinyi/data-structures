package com.kinyi.set;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Kinyi_Chan
 * @since 2019-06-04
 */
public class BSTSetTest {

    @Test
    public void test() {
        System.out.println("file.txt");
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("file.txt", words);
        System.out.println("Total words: " + words.size());

        BSTSet<String> set = new BSTSet<>();
        for (String word : words) {
            set.add(word);
        }
        System.out.println("Total different words: " + set.getSize());
    }
}