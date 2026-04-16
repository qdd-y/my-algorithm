package cn.qdd.algorithm.tree;

/**
 * @Author: qdd
 * @Description: ReverseTree
 * @DateTime: 2026/4/16 16:35
 **/
public class ReverseTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(2,new TreeNode(5),new TreeNode(6)), new TreeNode(3));
        TreeNode treeNode = new ReverseTree().invertTree(node1);
        System.out.println(treeNode.left.val);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
