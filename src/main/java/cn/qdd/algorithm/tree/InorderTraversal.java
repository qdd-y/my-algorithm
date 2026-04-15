package cn.qdd.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qdd
 * @Description: InorderTraversal
 * @DateTime: 2026/4/15 16:43
 **/
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> list = new InorderTraversal().inorderTraversal(node1);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        change(root,list);
        return list;
    }

    void change(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        change(root.left,list);
        list.add(root.val);
        change(root.right,list);
    }

}
