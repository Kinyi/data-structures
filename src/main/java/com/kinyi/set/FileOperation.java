package com.kinyi.set;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * 文件相关操作
 *
 * @author Kinyi_Chan
 * @since 2019-06-04
 */
public class FileOperation {

    /**
     * 读取文件名称为fileName中的内容, 并将其中包含的所有单词放进words中
     *
     * @param fileName
     * @param words
     * @return
     */
    public static boolean readFile(String fileName, List<String> words) {
        if (fileName == null || words == null) {
            System.out.println("fileName is null or words is null");
            return false;
        }
        //文件读取
        //简单分词
        //这个分词方式相对简陋, 没有考虑很多文本处理中的特殊问题
        //在这里只做demo展示用
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.read() != -1) {
                String contents = br.readLine();
                int start = firstCharacterIndex(contents, 0);
                for (int i = start + 1; i <= contents.length(); ) {
                    if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                        String word = contents.substring(start, i).toLowerCase();
                        words.add(word);
                        start = firstCharacterIndex(contents, i);
                        i = start + 1;
                    } else {
                        i++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 寻找字符串s中, 从start的位置开始的第一个字母字符的位置
     *
     * @param s
     * @param start
     * @return
     */
    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }
        }
        return s.length();
    }

}