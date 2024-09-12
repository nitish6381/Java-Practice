package org.example.java_practice;

import java.util.*;
import java.util.stream.Collectors;

public class Perennial {
    public static void main(String[] args){
        String str = "pineapple";
        char[] array = str.toCharArray();
//        List<Character> list = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i<array.length;i++){
            map.put(array[i], map.getOrDefault(array[i], 0)+1);
        }
        List<Character> result =  map.entrySet().stream().filter(
                e->{
                    if(e.getValue() == 1){
                        return true;
                    } else {
                        return false;
                    }
                }
        ).map(e->e.getKey()).toList();

//        List<Character> result = list.stream().filter(
//                e->{
//                        int count  =0;
//                        for(int j = 0;j<str.length();j++){
//                            if(e.equals(str.charAt(j))){
//                                count++;
//                            }
//                        }
//                        if(count == 1){
//                            return true;
//                        } else {
//                            return false;
//                        }
//                    if(map.get(e) == 1){
//                        return true;
//                    } else {
//                        return false;
//                    }
//                }
//        ).collect(Collectors.toList());
        System.out.println(result.get(0));
    }
}
