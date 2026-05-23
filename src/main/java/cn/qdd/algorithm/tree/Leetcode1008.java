package cn.qdd.algorithm.tree;

import com.sun.source.tree.Tree;

/**
 * @Author: qdd
 * @Description: Leetcode1008
 * @DateTime: 2026/5/22 16:42
 **/
public class Leetcode1008 {
    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        TreeNode treeNode = new Leetcode1008().bstFromPreorder(preorder);
        System.out.println(treeNode);
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return insert(preorder, Integer.MAX_VALUE);
    }
    int i = 0;
    public TreeNode insert(int[] preorder,int max){
        if (i == preorder.length) return null;
        int val = preorder[i];
        if (val > max) return null;
        TreeNode node = new TreeNode(val);
        i++;
        node.left = insert(preorder, val);
        node.right = insert(preorder, max);
        return node;
    }

    public TreeNode insert(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        if(val < root.val){
            root.left = insert(root.left,val);
        }else if(val > root.val){
            root.right = insert(root.right,val);
        }
        return root;
    }
    public TreeNode partition(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        // 找到左右子树的分界点
        int i = 1;  // 在循环外声明
        for (; i < preorder.length; i++) {
            if (preorder[i] > root.val) {
                break;
            }
        }
        // 左子树：从索引1到i-1（所有小于根节点的值）
        int[] left = new int[i - 1];
        System.arraycopy(preorder, 1, left, 0, i - 1);

        // 右子树：从索引i到末尾（所有大于根节点的值）
        int[] right = new int[preorder.length - i];
        System.arraycopy(preorder, i, right, 0, preorder.length - i);

        root.left = partition(left);
        root.right = partition(right);

        return root;
    }
}
