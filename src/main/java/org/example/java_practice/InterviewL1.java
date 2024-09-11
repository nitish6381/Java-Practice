package org.example.java_practice;

import java.util.*;

public class InterviewL1 {
    public static void main(String[] args) {
//        divide a string in ‘n’ equal parts:
//        String str = “abcdefghi”;
//        int n = 3;
//        Output:
//        Part 1: abc
//        Part 2: def
//        Part 3: ghi
        String str = "abcdefghi";
        int n = 3;
        List<String> strs = new ArrayList<>();
        for(int i = 0;i<str.length();i+=n) {
            String temp = "";
            for (int j = i; j <= i + n-1; j++) {
                String t1 = String.valueOf(str.charAt(j));
                temp = temp + t1;
            }
            strs.add(temp);
        }

        strs.stream().forEach(e-> System.out.println(e));


        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<myList.size();i++){
            map.put(myList.get(i), map.getOrDefault(myList.get(i), 0)+1);
        }

        map.entrySet().stream().forEach(e-> System.out.println(e.getKey()+ " --> "+e.getValue()));

//        myList.stream().

    }
}
