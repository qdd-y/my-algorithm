package cn.qdd.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: qdd
 * @Description: IsValidBST
 * @DateTime: 2026/4/23 17:13
 **/
public class IsValidBST {
    public static void main(String[] args) {
            TreeNode node1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
            boolean validBST = new IsValidBST().isValidBST(node1);
            System.out.println(validBST);
    }

    List<Integer> list = new ArrayList<>();
    //递归
    public boolean isValidBST(TreeNode root) {
        traversal(root);
        for (int i = 1; i < list.size(); i++){
            if (list.get(i-1) >= list.get(i)) return false;
        }
        return true;
    }
    public void traversal(TreeNode root){
        if (root == null) return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }

    //非递归方式
    public boolean isValidBST1(TreeNode root){
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        Long pre = Long.MIN_VALUE;
        while(p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                p = p.left;
            }else {
                TreeNode pop = stack.pop();
                if (pre >= pop.val){
                    return false;
                }
                pre = (long) pop.val;
                p = pop.right;
            }
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root){
        long pre = Long.MIN_VALUE;
        if(root == null){
            return true;
        }
        boolean a = isValidBST2(root.left);
        //减少执行步骤 左子树不通过就不再递归后面的
        if (!a){
            return false;
        }
        if (pre >= root.val){
            return false;
        }
        return isValidBST2(root.right);
    }

    public boolean isValidBST3(TreeNode root){
        return doValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean doValid(TreeNode root, Long min, Long max){
        if (root == null) return true;
        if (root.val <= min ||root.val >= max) return false;
        return doValid(root.left,min, (long) root.val)&&doValid(root.right, (long) root.val,max);
    }
}
