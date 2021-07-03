package InterviewImportant.Arithmiy;

public class Day0703 {


    //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
    // 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {

            int  mid = (left+right)/2;

            if (nums[mid]==target){

                return mid;
            } else if (nums[mid] < target) {
                left = mid+1;

            }else {
                right = mid-1;
            }
        }

        return -1;
    }



    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，
    // 返回它将会被按顺序插入的位置。你可以假设数组中无重复元素。
    public static int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;

    }


    public static void main(String[] args) {
        int[] ar ={1,3,5,6};

        System.out.println(searchInsert(ar, 2));
    }



}
