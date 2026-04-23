package cn.qdd.algorithm.tree;

import java.util.ArrayList;
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
}
