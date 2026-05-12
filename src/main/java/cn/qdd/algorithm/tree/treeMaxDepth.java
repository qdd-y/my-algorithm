package cn.qdd.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: qdd
 * @Description: treeMaxDepth
 * @DateTime: 2026/4/15 16:50
 **/
public class treeMaxDepth {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(2,new TreeNode(5),new TreeNode(6)), new TreeNode(3));
        int i = new treeMaxDepth().maxDepth4(node1);
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int ans = Math.max(leftMax, rightMax)+1;
        return ans;
    }

    public int maxDepth1(TreeNode root){
        //得到左右子树的深度，比较最大值
        if(root == null) return 0;
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        //当前节点的深度( +1 是关键)
        return Integer.max(left,right) + 1;
    }

    //非递归方式 利用栈来解决
    public int maxDepth3(TreeNode root){
        TreeNode cur = root;
        TreeNode pop = null;
        int max = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                int size = stack.size();
                if (size > max) max = size;
                cur = cur.left;
            } else{
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop){
                    pop = stack.pop();
                }else {
                    cur = peek.right;
                }
            }
        }
        return max;
    }

    //层序遍历
    public int maxDepth4(TreeNode root){
        Queue<TreeNode> que = new LinkedList<>();
        int maxDepth = 0;
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            while(len > 0){
                TreeNode poll = que.poll();
                if (poll.left != null) que.offer(poll.left);
                if (poll.right != null) que.offer(poll.right);
                len--;
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
