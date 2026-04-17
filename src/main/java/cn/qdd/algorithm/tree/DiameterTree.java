package cn.qdd.algorithm.tree;

/**
 * @Author: qdd
 * @Description: DiameterTree
 * @DateTime: 2026/4/17 19:18
 **/
public class DiameterTree {
    int ans = 0;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(2,new TreeNode(4),new TreeNode(5)), new TreeNode(3));
        int diameterOfBinaryTree = new DiameterTree().diameterOfBinaryTree(node1);
        System.out.println(diameterOfBinaryTree);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        //左子树的深度
        int lDepth = dfs(root.left);
        //右子树的深度
        int rDepth = dfs(root.right);
        //更新最大直径（最大直径 == 左边最长的加右边最长的）
        ans = Math.max(ans,lDepth+rDepth);
        //返回当前节点的深度（当前节点的深度 == 左边最长的和右边最长的最大值 + 1）
        return Math.max(lDepth,rDepth)+1;
    }
}
