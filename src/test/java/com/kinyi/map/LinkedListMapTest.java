package com.kinyi.map;

import com.kinyi.set.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Kinyi_Chan
 * @since 2019-06-05
 */
public class LinkedListMapTest {

    @Test
    public void test() {
        List<String> words = new ArrayList<>();
        if (FileOperation.readFile("file.txt", words)) {
            System.out.println("Total words: " + words.size());
            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of hello: " + map.get("hello"));
        }
    }
}