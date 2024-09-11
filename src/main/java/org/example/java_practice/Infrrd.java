package org.example.java_practice;

import java.util.ArrayList;
import java.util.List;

public class Infrrd {
    public static void main(String[] args) {
        String[] strs = new String[]{"abcabcba", "bbbb", "pwwke"};
        List<String> result = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            String temp = strs[i];
            int max = 0;
            String maxSubSring = "";
            String temp1 = "";
            for(int j=0;j<temp.length();j++){
                String t1 = String.valueOf(temp.charAt(j));
                if(temp1.contains(t1)){
                    if(temp1.length() > max){
                        maxSubSring = temp1;
                        max = temp1.length();
                        temp1 = t1;
                    }
                }else{
                    temp1 = temp1 + temp.charAt(j);
                }
            }
            if(temp1.length() > max){
                maxSubSring = temp1;
            }
            result.add(maxSubSring);

        }
        result.stream().forEach(e-> System.out.println(e));
    }
}
