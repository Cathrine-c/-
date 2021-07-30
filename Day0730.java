package InterviewImportant.jianzhi;

public class Day0730 {


    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int max_Profit=0;
        int price = 0;

        for(int i=1;i<prices.length;i++){
            for(int j=0;j<i;j++){
                price = prices[i]-prices[j];
                max_Profit = max_Profit>price?max_Profit:price;
            }

        }

        return max_Profit;

    }


    public int maxProfit1(int[] prices) {

        if (prices.length==0||prices==null)return 0;

        int min = prices[0];
        int res = 0;
        for (int i=1;i<prices.length;i++){

            if (prices[i] <min){
                min = prices[i];
            }else {

                res = Math.max(res,prices[i]-min);
            }

        }
        return res;

    }


    public static int maxProfit2(int[] prices) {
        if (prices.length==0||prices==null)return 0;

        int max = 0;
        int n = prices.length;

        int[] dp = new int[n];
        dp[1] = prices[1]-prices[0];

        max = Math.max(dp[1],max);

        for (int i=2;i<n;i++){
            int j = i-1;

            if(dp[j]>0){

                dp[i] = prices[i]-prices[j]+dp[j];

            }else {

                dp[i] = prices[i]-prices[j];

            }
            max = Math.max(max,dp[i]);

        }

        return max;

    }


    public static void main(String[] args) {
        int[] a={7,1,5,3,6,4};
        System.out.println(maxProfit2(a));

    }

}
