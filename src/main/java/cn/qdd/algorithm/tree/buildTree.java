package cn.qdd.algorithm.tree;

import java.util.Arrays;

/**
 * @Author: qdd
 * @Description: 前序和中序遍历构造二叉树
 * @DateTime: 2026/4/26 15:23
 **/
public class buildTree {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = new buildTree().buildTree2(preorder, inorder);
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

    public TreeNode buildTree2(int[] preorder, int[] inorder){
        if (preorder.length == 0){
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        //中序遍历中找到跟的位置
        for(int i = 0; i < inorder.length; i++){
            if (rootValue == inorder[i]){
                //分割中序的左右子树
                //左 0 - i-1   右 i+1 - inorder.length-1
                int[] inLeft = Arrays.copyOfRange(inorder,0,i);
                int[] inRight = Arrays.copyOfRange(inorder,i+1,inorder.length);
                //分割前序遍历的左右子树
                //左 1 - i  右 i+1 - inorder.length
                int[] preLeft = Arrays.copyOfRange(preorder,1,i+1);
                int[] preRight = Arrays.copyOfRange(preorder,i+1,inorder.length);
                //递归构造树
                root.left = buildTree2(inLeft,preLeft);
                root.right = buildTree2(inRight,preRight);
            }
        }
        return root;
    }
}
