package cn.qdd.algorithm.tree;

import com.sun.source.tree.Tree;

/**
 * @Author: qdd
 * @Description: TreeNode
 * @DateTime: 2026/4/15 16:43
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){};

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
