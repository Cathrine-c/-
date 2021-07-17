package InterviewImportant.jianzhi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day0717 {

    public static void main(String[] args) {

        int[] a = {45,46,67,73,74,74,77,83,89,98};
        int target = 147;

        System.out.println(Arrays.toString(twoSum(a,target)));

    }


    public static int[] twoSum(int[] nums, int target) {
        int left= 0;
        int right = nums.length-1;
        int[] arr = new int[2];

        while (left < right) {

            while(left<right&&nums[left]+nums[right]<target)left++;


            while(left<right&&nums[left]+nums[right]>target)right--;


            if (nums[left] + nums[right] == target) {
                arr[0] = nums[left];
                arr[1] = nums[right];
                break;
            }

        }

        return arr;

    }



    public int[][] findContinuousSequence(int target) {

        List<int[]> list = new ArrayList<>();

        for (int l=1,r=1,sum=0;r<target/2+1;r++){
            sum+=r;

            while (sum > target) {
                sum -=l++;

            }

            if (sum==target){

                int[] a = new int[r-l+1];

                for (int i=0;i<a.length;i++){
                    a[i] = l+i;
                }
            }

        }
        int[][] res = new int[list.size()][];

        for (int i=0;i<res.length;i++){

            res[i]  = list.get(i);


        }
        return res;

    }



}
