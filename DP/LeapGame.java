package InterviewImportant.DP;

import java.util.ArrayList;
import java.util.List;

public class LeapGame {

    //给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
    //数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //判断你是否能够到达最后一个下标。
    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];

        dp[0] = true;

        for (int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){

                if (dp[j]&&(i-j)<=nums[j]){
                    dp[i] = true;
                }

            }
        }

        return dp[nums.length-1];

    }


    public static void main1(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));
    }



    //给定一个非负整数数组，你最初位于数组的第一个位置。
    //数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    //假设你总是可以到达数组的最后一个位置。
    public static int jump(int[] nums) {

        int count =0;
        for (int i=nums.length-1;i>=0;i--){
            if (i == 0) {
                break;
            }


            int minIndex = 0;

            for (int j=i-1;j>=0;j--){

                if (nums[j] >= i - j) {

                        minIndex = j;

                }
            }

            count++;
            i = minIndex+1;
        }
        return count;

    }



    //动态规划解法
    public static int jumpwithDp(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];

        dp[0] = 0;
        for (int i=1;i<len;i++){

            dp[i] = Integer.MAX_VALUE;

        }

        for (int i=0;i<len;i++){

            for (int j=i+1;j<len&&j<=i+nums[i];j++){

                dp[j] = Math.min(dp[j],dp[i]+1);

            }
        }
        return dp[len-1];

    }


    //给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//    public int integerBreak(int n) {
//
//
//    }





    public static void main(String[] args) {
        int[] arr = {2,3,1};
        System.out.println(jump(arr));
    }
}
