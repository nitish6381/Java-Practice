package org.example.java_practice;


import java.util.ArrayList;
import java.util.List;

public class DBSInterview {
    public static List<Integer> removeSamllVal(List<Integer> arr, int val, int first){
        List<Integer> res = new ArrayList<>();
        for (int j= 0;j < arr.size();j++){
            if(arr.get(j)==first){
                res.add(first);
            }
            else if(arr.get(j)<val){
//                nothing
            }else{
                res.add(arr.get(j));
            }
        }
        return res;
    };
    public static void main(String[] args){
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(116);
        list.add(78);
        list.add(110);
        list.add(120);
        list.add(126);
        list.add(100);
        list.add(98);

        result.add(0);
        for(int i=list.size()-1;i>0;i--){
            if(list.get(i)>list.get(0)){
                result.add(list.get(i));
                result = removeSamllVal(result, list.get(i), list.get(0));
            }
        }
        List<Integer> finalResult = new ArrayList<>();
        finalResult.add(list.get(0));
        for(int i=result.size() -1;i>=0;i--){
            finalResult.add(result.get(i));
        }
        for(int i=0;i<finalResult.size();i++){
            System.out.println(finalResult.get(i));
        }
//        return result;
    }
}
