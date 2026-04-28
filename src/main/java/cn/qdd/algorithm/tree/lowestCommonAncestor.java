package cn.qdd.algorithm.tree;

/**
 * @Author: qdd
 * @Description: lowestCommonAncestor
 * @DateTime: 2026/4/28 16:15
 **/
public class lowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(2,new TreeNode(4),new TreeNode(5)), new TreeNode(3));
        TreeNode treeNode = new lowestCommonAncestor().lowestCommonAncestor1(node1, node1.left.left, node1.left.right);
        System.out.println(treeNode.val);
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor1(root.left,p,q);
        TreeNode right = lowestCommonAncestor1(root.right,p,q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
