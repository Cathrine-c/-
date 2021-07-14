package InterviewImportant.jianzhi;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//两个栈实现队列
class CQueue {

    Stack stack1;
    Stack stack2;

    public CQueue() {
        stack1 = new Stack();
        stack2 = new Stack();

    }

    //入队列
    public void appendTail(int value) {
        stack1.push(value);

    }

    //出队列
    public int deleteHead() {

        if (stack2.isEmpty()) {
            if (stack1.isEmpty())return -1;

            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

            return (int) stack2.pop();

        }else {
            return (int) stack2.pop();
        }
    }



}


public class Day0714 {



    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */

    public static int fib(int n) {

        if (n<=1){
            return n;
        }

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i=2;i<=n;i++){

            arr[i] = (arr[i-1]+arr[i-2])%1000000007;
        }
        return arr[n];
    }


    //找出数组中重复的数字。
    //在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
    // 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
    public static int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++){

            if (map.containsKey(nums[i])){
                return nums[i];

            }else {
                map.put(nums[i],1);

            }

        }

        return -1;

    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */
    public static int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = dp[0]+1;
        for (int i=2;i<n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;

        }

        return dp[n-1];
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     */
    public static int minArray(int[] numbers) {

        int left = 0;
        int right = numbers.length-1;

        while (left < right) {

            int mid = (left+right)/2;

            if (numbers[mid]<numbers[right]){
                right = mid;

            }else if (numbers[mid]>numbers[right]){
                left = mid +1;

            }else {
                right--;
            }
        }
        return numbers[left];

    }


    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {

            while (left < right && nums[right] % 2 == 0) {
                right--;

            }
            while (left < right && nums[left] % 2 != 0) {
                left++;

            }
            swap(nums,left,right);
        }
        return nums;
    }

    private void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

    }


    public static void main1(String[] args) {

        int n = 5;
        System.out.println(hammingWeight(n));

    }


    //编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {

            if ((n & 1) == 1) {
                count++;
            }

            n>>>=1;
        }

        return count;
    }


    /**
     *1 2 3
     *4 5 6      123 -> 6 9   ->  69   -> 8 7  -> 87  ->4 5
     *7 8 9             5 8               5 4
     *                  4 7
     */
    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {

            return new int[]{};
        }
        int w = matrix.length;
        int l = matrix[0].length;

        int[] newArr = new int[w*l];
        int left = 0,right = l-1;
        int top = 0,bottom = w-1;

        int k = 0;
        while (true) {

            for (int i=left;i<=right;i++){
                newArr[k++] = matrix[top][i];
            }
            top++;
            if (top>bottom)break;

            for (int i=top;i<=bottom;i++){
                newArr[k++] = matrix[i][right];
            }

            right--;
            if (left>right)break;

            for (int i=right;i>=left;i--){
                newArr[k++] = matrix[bottom][i];

            }
            bottom--;
            if (top>bottom)break;

            for (int i=bottom;i>=top;i--){
                newArr[k++] = matrix[i][left];

            }
            left++;
            if (left>right)break;


        }
        return newArr;

    }


    public static void main(String[] args) {

        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(Arrays.toString(spiralOrder(arr)));
    }

    //输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
    public int[] printNumbers(int n) {




    }


}
