package InterviewImportant.jianzhi;

public class Day0728 {




    //礼物的最大价值
    public static int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for(int i=1;i<grid.length;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];

        }

        for(int i=1;i<grid[0].length;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];

        }


        for(int i = 1;i<grid.length;i++){
            for(int j =1;j<grid[0].length;j++){
                dp[i][j] = Math.max(dp[i][j-1]+grid[i][j],dp[i-1][j]+grid[i][j]);

            }
        }

        return dp[grid.length-1][grid[0].length-1];

    }


    // 最长不含重复字符的子字符串
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int len = 0;
        int maxLen = 0;

        int k=0;
        for(int i = 0;i < s.length();i++){
            for(int j = i-1;j>=k;j--){
                if(chars[i]==chars[j]){
                    len = i-j-1;
                    k=j;
                    break;

                }

            }
            len++;
            maxLen = maxLen>len?maxLen:len;

        }

        return maxLen;

    }


    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));

    }


}
