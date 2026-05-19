package cn.qdd.algorithm.tree;

import java.util.Arrays;

/**
 * @Author: qdd
 * @Description: 中序和后序遍历
 * @DateTime: 2026/5/17 15:46
 **/
public class buildTree2 {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode treeNode = new buildTree2().buildTree(inorder, postorder);
        System.out.println(treeNode.val);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder){
        if (inorder.length == 0){
            return null;
        }
        //根
        int rootValue = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootValue);
        //中序中找根
        for(int i = 0; i < inorder.length; i++){
            if (rootValue == inorder[i]){
                //分左右子树
               int[] inLeft = Arrays.copyOfRange(inorder,0,i);
               int[] inRight = Arrays.copyOfRange(inorder,i+1,inorder.length);

               int[] postLeft = Arrays.copyOfRange(postorder,0,i);
               int[] postRight = Arrays.copyOfRange(postorder,i,postorder.length-1);
               root.left = buildTree(inLeft,postLeft);
               root.right = buildTree(inRight,postRight);
            }
        }
        return root;
    }
}
