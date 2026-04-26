package cn.qdd.algorithm.tree;

import java.util.Arrays;

/**
 * @Author: qdd
 * @Description: buildTree
 * @DateTime: 2026/4/26 15:23
 **/
public class buildTree {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = new buildTree().buildTree1(preorder, inorder);
        System.out.println(treeNode.val);
    }
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++){
            if (preorder[0] == inorder[i]){
                index = i;
                break;
            }
        }
        int[] left_preorder = Arrays.copyOfRange(preorder,1,1+index);
        int[] left_inorder = Arrays.copyOfRange(inorder,0,index);
        root.left = buildTree1(left_preorder,left_inorder);
        int[] right_preorder = Arrays.copyOfRange(preorder,index+1,preorder.length);
        int[] right_inorder = Arrays.copyOfRange(inorder,index+1,inorder.length);
        root.right = buildTree1(right_preorder,right_inorder);
        return root;
    }
}
