package cn.qdd.algorithm;

/**
 * @Author: qdd
 * @Description: MoveZero
 * @DateTime: 2026/3/12 14:01
 **/
public class MoveZero {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3};
        new MoveZero().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }


    public void moveZeroes(int[] nums) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                    nums[pointer] = nums[i];
                    pointer++;
            }
        }
        //第一个for把所有不是0的数字移到前面去，pointer指向的就是第一个0，至此pointer之前的元素都不是0
        //第二个for是把pointer之后的赋值为0
        for(int i = pointer; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
