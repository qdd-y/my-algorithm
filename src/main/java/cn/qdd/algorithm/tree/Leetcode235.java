package cn.qdd.algorithm.tree;

/**
 * @Author: qdd
 * @Description: Leetcode235
 * @DateTime: 2026/5/22 17:24
 **/
public class Leetcode235 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6, new TreeNode(2), new TreeNode(8));
        TreeNode node2 = new TreeNode(2, new TreeNode(0), new TreeNode(4));
        TreeNode node3 = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        node1.left = node2;
        node1.right = node3;
        TreeNode treeNode = new Leetcode235().lowestCommonAncestor(node1, node2, node3);
        System.out.println(treeNode.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = root;
        while(p.val < a.val && q.val < a.val || p.val > a.val && q.val > a.val){
            if(p.val < a.val){
                a = a.left;
            }else{
                a = a.right;
            }
        }
        return a;
    }
}
