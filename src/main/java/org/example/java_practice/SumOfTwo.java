package org.example.java_practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumOfTwo {
    public int[] twoSum(int[] nums, int target) {
        int arr[] = nums;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(i, arr[i]);
        }
        Arrays.sort(arr);
        int leftNode = 0;
        int rightNode = arr.length - 1;
        int leftNodeValue = arr[leftNode];
        int rightNodeValue = arr[rightNode];
        int sum = leftNodeValue + rightNodeValue;
        while (leftNode < rightNode){
            if(sum == target){
                break;
            }
            if(sum > target){
                --rightNode;
            }
            if(sum < target){
                ++leftNode;
            }
            sum = arr[leftNode] + arr[rightNode];
        }
        int arr1[] = new int[2];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == arr[leftNode] && arr1[1] != entry.getKey() && arr1[0] == 0){
                arr1[0] = entry.getKey();
            }
            if(entry.getValue() == arr[rightNode] && arr1[0] != entry.getKey() && arr1[1] == 0){
                arr1[1] = entry.getKey();
            }
        }
        return arr1;
    }
}
