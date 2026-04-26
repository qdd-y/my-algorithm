package cn.qdd.algorithm.tree;

/**
 * @Author: qdd
 * @Description: flatten
 * @DateTime: 2026/4/26 15:06
 **/
public class flatten {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(2,new TreeNode(3),new TreeNode(4)), new TreeNode(5,new TreeNode(6),null));
        new flatten().flatten1(node1);
        //输出链表
        TreeNode cur = node1;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.right;
        }
    }
    TreeNode pre = null;
    public void flatten1(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (pre != null){
            pre.right = root;
        }
        pre = root;
        pre.right = null;
        pre.left = null;
        flatten1(left);
        flatten1(right);
    }
}
