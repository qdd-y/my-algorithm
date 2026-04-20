package cn.qdd.algorithm.tree;

/**
 * @Author: qdd
 * @Description: BalancedTree
 * @DateTime: 2026/4/20 18:53
 **/
public class BalancedTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(2,new TreeNode(4),new TreeNode(5)), new TreeNode(3));
        boolean balanced = new BalancedTree().isBalanced(node1);
        System.out.println(balanced);
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helper(root) != -1;
    }

    public int helper(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left -right) > 1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }
}
