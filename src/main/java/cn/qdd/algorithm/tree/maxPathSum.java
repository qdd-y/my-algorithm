package cn.qdd.algorithm.tree;


/**
 * @Author: qdd
 * @Description: maxPathSum
 * @DateTime: 2026/4/29 16:21
 **/
public class maxPathSum {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10, new TreeNode(9), new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        int i = new maxPathSum().maxPathSum1(node1);
        System.out.println(i);
    }
    int ans = Integer.MIN_VALUE;
    public int maxPathSum1(TreeNode root) {
        getMax(root);
        return ans;
    }
    public int getMax(TreeNode root){
        if (root == null) return 0;
        int left = Math.max(0,getMax(root.left));
        int right = Math.max(0,getMax((root.right)));
        ans =Math.max(ans,left + right + root.val);
        return Math.max(left,right) + root.val;
    }

}
