package com.kinyi.tree.bst.leetcode;

/**
 * @author Kinyi_Chan
 * @since 2019-05-28
 */
public class UniqueMorseCodeWords {

    class SBT<E extends Comparable<E>> {

        private class Node {
            private E e;
            private Node left;
            private Node right;

            public Node(E e) {
                this.e = e;
                left = null;
                right = null;
            }
        }

        private Node root;
        private int size;

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 向二分搜索树中添加新的元素e
         *
         * @param e
         */
        public void add(E e) {
            if (root == null) {
                root = new Node(e);
                size++;
            } else {
                add(root, e);
            }
        }

        /**
         * 向以node为根的二分搜索树中插入元素e，递归算法
         *
         * @param node
         * @param e
         */
        public void add(Node node, E e) {
            if (e.equals(node.e)) {
                return;
            } else if (e.compareTo(node.e) < 0 && node.left == null) {
                node.left = new Node(e);
                size++;
                return;
            } else if (e.compareTo(node.e) > 0 && node.right == null) {
                node.right = new Node(e);
                size++;
                return;
            }
            if (e.compareTo(node.e) < 0) {
                add(node.left, e);
            } else {
                add(node.right, e);
            }
        }
    }


    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            SBT<String> tree = new SBT<>();
            String[] pass = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
            for (String word : words) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    sb.append(pass[word.codePointAt(i) - 97]);
                }
                tree.add(sb.toString());
            }
            return tree.getSize();
        }
    }

    public static void main(String[] args) {
        String word = "kinyi";
        for (int i = 0; i < word.length(); i++) {
            System.out.println(word.codePointAt(i) - 97);
        }
    }
}
