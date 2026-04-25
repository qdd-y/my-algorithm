package cn.qdd.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: qdd
 * @Description: rightSideView
 * @DateTime: 2026/4/25 16:29
 **/
public class rightSideView {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        List<Integer> list = new rightSideView().rightSideView1(node1);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView1(TreeNode root) {
        checkFun(root);
        return list;
    }
    public void checkFun(TreeNode root){
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            int index = 0;
            while(len > 0){
                TreeNode item = que.poll();
                if (index == 0) list.add(item.val);
                if (item.right != null) que.offer(item.right);
                if (item.left != null) que.offer(item.left);
                len--;
                index++;
            }
        }
    }
}
