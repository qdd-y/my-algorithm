package cn.qdd.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: qdd
 * @Description: LevelOrder
 * @DateTime: 2026/4/19 15:14
 **/
public class LevelOrder {

    private List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3, new TreeNode(9,new TreeNode(1),new TreeNode(2)), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> list = new LevelOrder().levelOrder(node1);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
//        checkFun(root,0);
        checkFun2(root);
        return list;
    }
    public void checkFun(TreeNode root, int deep){
        if(root == null) return;
        deep++;
        if(list.size() < deep){
            List<Integer> item = new ArrayList<>();
            list.add(item);
        }
        list.get(deep-1).add(root.val);
        checkFun(root.left,deep);
        checkFun(root.right,deep);
    }

    public void checkFun2(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            List<Integer> item = new ArrayList<>();
            while (len > 0) {
                TreeNode itemNode = que.poll();
                item.add(itemNode.val);
                if (itemNode.left != null) que.offer(itemNode.left);
                if (itemNode.right != null) que.offer(itemNode.right);
                len--;
            }
            list.add(item);
        }
    }
}
