package InterviewImportant.DP;



//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}


public class Test7Medium {


        //给你一个整数 n ，请你找出并返回第 n 个 丑数 。
        //丑数 就是只包含质因数 2、3 和/或 5 的正整数。
        public int nthUglyNumber(int n) {

            int[] dp = new int[n];
            int n2 = 0, n3 = 0, n5 = 0;
            dp[0] = 1;

            for (int i = 1; i < n; i++) {

                dp[i] = Math.min(2 * dp[n2], Math.min(3 * dp[n3], 5 * dp[n5]));

                if (dp[i] == 2 * dp[n2]) n2++;
                if (dp[i] == 3 * dp[n3]) n3++;
                if (dp[i] == 5 * dp[n5]) n5++;

            }

            return dp[n - 1];
        }


        //编写一段程序来查找第 n 个超级丑数。
        //超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
        public int NthSuperUglyNumber(int n, int[] primes) {

            int[] countArray = new int[primes.length];

            int[] dp = new int[n];

            for (int i = 1; i < n; i++) {

                dp[i] = Integer.MAX_VALUE;
                for (int y = 0; y < countArray.length; y++) {
                    dp[i] = Math.min(dp[i], dp[countArray.length - 1]);

                }
                for (int z = 0; z < primes.length; z++) {
                    if (dp[i] % primes[z] == 0) {
                        countArray[z]++;

                    }
                }

            }
            return dp[n - 1];

        }


        //给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
        public int maxProduct(int[] nums) {

            if (nums.length == 0) {
                return 0;
            }

            //[-2,3,-4]->24
            int[][] dp = new int[nums.length][2];//dp[i][0]保存以i结尾的最大值,dp[i][1]保存以i结尾的最小值
            dp[0][0] = nums[0];
            dp[0][1] = nums[0];


            int multipy_Max = dp[0][0];

            for (int i = 1; i < nums.length; i++) {

                int t1 = nums[i] * dp[i - 1][0];

                int t2 = nums[i] * dp[i - 1][1];

                dp[i][0] = t1 > t2 ? Math.max(nums[i], t1) : Math.max(nums[i], t2);

                dp[i][1] = t1 > t2 ? Math.min(nums[i], t2) : Math.min(nums[i], t1);

                multipy_Max = Math.max(multipy_Max, dp[i][0]);

            }

            return multipy_Max;

        }


    }

