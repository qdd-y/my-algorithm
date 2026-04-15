package cn.qdd.algorithm.tree;

/**
 * @Author: qdd
 * @Description: treeMaxDepth
 * @DateTime: 2026/4/15 16:50
 **/
public class treeMaxDepth {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(2,new TreeNode(5),new TreeNode(6)), new TreeNode(3));
        int i = new treeMaxDepth().maxDepth(node1);
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int ans = Math.max(leftMax, rightMax)+1;
        return ans;
    }
}
