package cn.qdd.algorithm.tree;

import java.util.LinkedList;

/**
 * @Author: qdd
 * @Description: 后缀表达式构造树
 * @DateTime: 2026/5/17 14:59
 **/

public class PostfixNotationTree {
    public static void main(String[] args) {
        String[] tokens = {"3","4","+","2","*","7","/"};
        TreeNode treeNode = new PostfixNotationTree().PostfixNotationTree1(tokens);
        //后序遍历

    }

    static class TreeNode{
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }

        public TreeNode(String val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode PostfixNotationTree1(String[] tokens){
        LinkedList<TreeNode> stack = new LinkedList<>();
        for(String t : tokens){
            switch (t){
                case "+" , "-" , "*" , "/" ->{//运算符
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    TreeNode parent = new TreeNode(t,left,right);
                    stack.push(parent);
                }
                default -> {
                    stack.push(new TreeNode(t));
                }
            }
        }
        return stack.peek();
    }
}
