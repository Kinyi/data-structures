package com.kinyi.tree.bst.leetcode;

/**
 * 1038. 从二叉搜索树到更大和树
 *
 * @author Kinyi_Chan
 * @since 2019-06-10
 */
public class BinarySearchTreeToGreaterSumTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) {
            bstToGst(root.right);
        }
        sum = root.val = root.val + sum;
        if (root.left != null) {
            bstToGst(root.left);
        }
        return root;
    }

}























