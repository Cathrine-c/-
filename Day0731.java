package InterviewImportant.jianzhi;

public class Day0731 {


    public static void main(String[] args) {

    }


    public boolean isMatch(String s, String p) {
        if(s==null||p==null){
            return false;

        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for(int j=1;j<=p.length();j++){

            if(p.charAt(j-1)=='*'){//确定前面能否与空字符串匹配

                dp[0][j] = dp[0][j-2];

            }

            for(int i=1;i<=s.length();i++){

                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')dp[i][j] = dp[i-1][j-1];
                else{
                    if(p.charAt(j-1)=='*'){

                        if(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.')dp[i][j] = dp[i-1][j];
                        dp[i][j] = dp[i][j]||dp[i][j-2];

                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }



}
