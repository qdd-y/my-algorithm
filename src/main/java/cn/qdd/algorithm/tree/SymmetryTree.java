package cn.qdd.algorithm.tree;

/**
 * @Author: qdd
 * @Description: SymmetryTree
 * @DateTime: 2026/4/16 16:42
 **/
public class SymmetryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        boolean symmetric = new SymmetryTree().isSymmetric(node1);
        System.out.println(symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }

    public boolean check(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        return left.val == right.val&&check(left.left,right.right)&&check(left.right,right.left);
    }
}
