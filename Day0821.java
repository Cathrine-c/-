package InterviewImportant.jianzhi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day0821 {


    public static void main(String[] args) {

    }

    //思路：先把数组全部放进hash表中存储，然后在遍历hash表上，把上一次的value当作key，把遍历的结果
    //放在set中，如果出现重复，说明有环，则返回false
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length==0||numCourses==0)return true;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<prerequisites.length;i++){

            if(prerequisites[i][0]==prerequisites[i][1])return false;

            map.put(prerequisites[i][0],prerequisites[i][1]);


        }
        Set<Integer> set = new HashSet<>();

        int num = 0;

        for(int i=0;i<prerequisites.length;i++){

            set.add(prerequisites[i][0]);
            num = prerequisites[i][1];

            while(map.containsKey(num)){

                if(set.contains(num))return false;

                set.add(num);

                num = map.get(num);

            }
            set.clear();

        }
        return true;

    }



    //搜索旋转数组
    //整数数组 nums 按升序排列，数组中的值 互不相同 。
    //在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
    //使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
    //例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
    //给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(target==nums[mid]){
                return mid;

            }else if(nums[mid]<nums[right]){

                if(nums[mid]<target&&target<=nums[right]){

                    left = mid+1;

                }else{
                    right = mid-1;

                }

            }else{

                if(nums[left]<=target&&target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }


    //在排序数组中查找元素的第一个和最后一个位置
    //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    //如果数组中不存在目标值 target，返回 [-1, -1]。


}
