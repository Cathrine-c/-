package InterviewImportant.DP;

public class SubArray {

    //给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        int subArr_max =0;

        for (int i=1;i<=nums1.length;i++){
            for (int j=1;j<=nums2.length;j++){

                if (nums1[i-1]==nums2[j-1]){

                    dp[i][j] = dp[i-1][j-1] + 1;
                    subArr_max = Math.max(subArr_max,dp[i][j]);

                }
            }
        }

        return subArr_max;
    }


    //给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
    //一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，
    // 也就是景点的评分之和 减去 它们两者之间的距离。返回一对观光景点能取得的最高分。
    public static int maxScoreSightseeingPair(int[] values) {
        int[] dp = new int[values.length];

        dp[0] = values[0];

       // int comment_max = 0;

        for (int i=1;i<values.length;i++){
            for (int j=0;j<i;j++){
                dp[i] = Math.max(Math.max(dp[i-1],values[i]+values[j]+j-i),dp[i]);

              //  comment_max = comment_max>dp[i]?comment_max:dp[i];

            }
        }

        return dp[values.length-1];

    }


    public static int maxScoreSightseeingPair1(int[] values) {
        // 分成两部分
        // 1. 求 A[i] + i 的最大值
        // 2. 求 A[j] - j 的最大值

        int i=0;
        int Ai = values[0];
        int res = 0;
        for (int j=1;j<values.length;j++){

            res = Math.max(res,Ai+i+values[j]-j);
            if (values[j] + j > Ai + i) {

                i = j;

                Ai = values[j];

            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[] arr = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(arr));

    }
}
