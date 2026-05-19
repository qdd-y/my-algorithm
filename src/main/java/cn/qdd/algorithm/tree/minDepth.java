package cn.qdd.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: qdd
 * @Description: minDepth
 * @DateTime: 2026/5/13 16:53
 **/
public class minDepth {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(2,new TreeNode(4),new TreeNode(5)), new TreeNode(3));
        int minDepth = new minDepth().minDepth1(node1);
        System.out.println(minDepth);
    }
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        int minDepth = 1;
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            while(len > 0){
                TreeNode poll = que.poll();
                if (poll.left == null && poll.right == null) return minDepth;
                if (poll.left != null) que.offer(poll.left);
                if (poll.right != null) que.offer(poll.right);
                len--;
            }
            minDepth++;
        }
        return minDepth;
    }

}
