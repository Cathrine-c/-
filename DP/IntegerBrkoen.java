package InterviewImportant.DP;

public class IntegerBrkoen {


    //给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];

        dp[1] = 1;
        for (int i=2;i<=n;i++){

            for (int j=i-1;j>=1;j--){

//                int a = Math.max(j,dp[j]);
//                int b = Math.max(i-j,dp[i-j]);
//                dp[i] = Math.max(dp[i],a*b);

                dp[i] = Math.max(dp[i],dp[j]*(i-j));
                //dp[j]也是经过拆分的，需要判断合并是否比拆开乘积更大
                dp[i] = Math.max(dp[i],j*(i-j));

            }
        }
        return dp[n];

    }


    //我们正在玩一个猜数游戏，游戏规则如下：
    //我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
    //每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
    //然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。

     /**解答
     dp[i][j]表示从[i,j]中猜出正确数字所需要的最少花费金额.(dp[i][i] = 0)
     假设在范围[i,j]中选择x, 则选择x的最少花费金额为: max(dp[i][x-1], dp[x+1][j]) + x
     用max的原因是我们要计算最坏反馈情况下的最少花费金额(选了x之后, 正确数字落在花费更高的那侧)

     初始化为(n+2)*(n+2)数组的原因: 处理边界情况更加容易, 例如对于求解dp[1][n]时x如果等于1, 需要考虑dp[0][1](0不可能出现, dp[0][n]为0)
     而当x等于n时, 需要考虑dp[n+1][n+1](n+1也不可能出现, dp[n+1][n+1]为0)

     如何写出相应的代码更新dp矩阵, 递推式dp[i][j] = max(max(dp[i][x-1], dp[x+1][j]) + x), x~[i:j], 可以画出矩阵图协助理解, 可以发现
     dp[i][x-1]始终在dp[i][j]的左部, dp[x+1][j]始终在dp[i][j]的下部, 所以更新dp矩阵时i的次序应当遵循bottom到top的规则, j则相反, 由于
     i肯定小于等于j, 所以我们只需要遍历更新矩阵的一半即可(下半矩阵)
     **/

    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];

        for (int i=n;i>=1;i--){

            for (int j=i;j<=n;j++){

                if (i == j) {
                    dp[i][j] = 0;

                }else {

                    dp[i][j] = Integer.MAX_VALUE;
                    for (int x=i;x<=j;x++){

                        dp[i][j] = Math.min(dp[i][j],Math.max(dp[i][x-1],dp[x+1][j])+x);

                    }
                }
            }

        }

        return dp[1][n];

    }



    //给你一个整数数组 nums和一个整数 target。
    //向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个表达式 ：
    //例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
    //返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int i=0;i<nums.length;i++){

            sum+=nums[i];
        }

        if (target>sum)return 0;
        if ((target+sum)%2==1)return 0;

        int len = (target+sum)/2;
        int[] dp = new int[len+1];
        dp[0] = 1;

        for (int i=0;i<nums.length;i++){

            for (int j=len;j>=nums[i];j--){

                dp[j] += dp[j-nums[i]];

            }

        }

        return dp[len];

    }


    public static int findTargetSumWays1(int[] nums, int target) {

        int sum = 0;
        int n = nums.length;
        for (int i=0;i<n;i++){

            sum+=nums[i];
        }

        if (sum<Math.abs(target)){
            return 0;
        }

        int[][] dp = new int[n][2*sum+1];
        dp[0][sum+nums[0]]++;
        dp[0][sum-nums[0]]++;

        for (int i=1;i<n;i++){
            for (int j=0;j<=2*sum;j++){

                dp[i][j-nums[i]] += dp[i-1][j];
                dp[i][j+nums[i]] += dp[i-1][j];

            }
        }
        return dp[n-1][target+sum];

    }


    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1};
        int target = 3;

        System.out.println(findTargetSumWays1(nums, target));

    }
}
