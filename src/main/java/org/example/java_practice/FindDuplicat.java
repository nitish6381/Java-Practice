package org.example.java_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicat {
    private int[] findDuplicate(int arr[]){
        ArrayList result = new ArrayList();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;){
            if(arr[i] == arr[i+1]){
                result.add(arr[i]);
                for(int j=i+1;j<arr.length;j++){
                    if(arr[i] == arr[j]){
                        i++;
                    }else{
                        break;
                    }
                }
                i++;
            }else{
                i++;
            }
        }
        return (int[]) result.stream().mapToInt(i -> (int) i).toArray();
    }

    private int[] findDupliacteWithMap(int arr[]){
        ArrayList result = new ArrayList();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet() ){
            if(entry.getValue() > 1){
                result.add(entry.getKey());
            }
        }
        return (int[]) result.stream().mapToInt(i -> (int) i).toArray();
    }

    public int[] getDuplicate(){
        int arr[] = {4,3,2,3,8,2,3,1};
//        return findDuplicate(arr);
        int [] result = findDupliacteWithMap(arr);
        Arrays.sort(result);
        return result;

    }
}
