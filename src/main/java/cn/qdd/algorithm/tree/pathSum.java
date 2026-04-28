package cn.qdd.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qdd
 * @Description: pathSum
 * @DateTime: 2026/4/27 15:58
 **/
public class pathSum {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        int pathSum = new pathSum().pathSum1(node1, 8);
        System.out.println(pathSum);
    }
    Map<Long, Integer> map = new HashMap<>();
    int count = 0;
    int targetSum;
    public int pathSum1(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        map.put(0L,1);
        dfs(root,0L);
        return count;
    }

    public void dfs(TreeNode root,Long curSum){
        if (root == null) return;
        curSum = curSum + root.val;
        count = count + map.getOrDefault(curSum,0);
        map.put(curSum,map.getOrDefault(curSum - targetSum,0)+1);
        dfs(root.left,curSum);
        dfs(root.right,curSum);
        map.put(curSum,map.get(curSum)-1);
    }
}
