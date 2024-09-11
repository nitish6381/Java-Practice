package org.example.java_practice;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int res = -1;
        int left =0;
        int right= nums.length -1;
        if(nums.length == 0)
            return res;
        if(nums.length == 1 && nums[0] == target)
            return 0;
        if(nums.length == 2 && nums[0] == target)
            return 0;
        if(nums.length == 2 && nums[1] == target)
            return 1;
        while (left<=right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return res;
    }
}
