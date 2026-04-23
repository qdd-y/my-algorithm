package cn.qdd.algorithm.tree;

/**
 * @Author: qdd
 * @Description: ArrayToTree
 * @DateTime: 2026/4/22 16:07
 **/
public class ArrayToTree {
    public static void main(String[] args) {

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }

    public  TreeNode build(int[] nums, int left, int right){
        if (left > right) return null;
        int index = (left + right) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums,left,index-1);
        root.right = build(nums,index+1,right);
        return root;
    }

}
