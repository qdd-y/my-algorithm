package cn.qdd.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qdd
 * @Description: kthSmallest
 * @DateTime: 2026/4/24 15:09
 **/
public class kthSmallest {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        int kthSmallest = new kthSmallest().kthSmallest1(node1, 1);
        System.out.println(kthSmallest);
    }

    List<Integer> list = new ArrayList<>();
    public int kthSmallest1(TreeNode root, int k) {
        traversal(root);
        return list.get(k-1);
    }
    public void traversal(TreeNode root){
        if (root == null) return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
