package org.example.java_practice;

import java.util.HashMap;
import java.util.Map;

 class Solution {
     public boolean findSubString(String str, String t){
         Map<String, Integer> mapt = new HashMap<>();
         Map<String, Integer> mapStr = new HashMap<>();
         for(int i=0;i<str.length();i++){
             mapStr.put(String.valueOf(str.charAt(i)), mapStr.getOrDefault(String.valueOf(str.charAt(i)), 0)+1);
         }
         for(int i=0;i<t.length();i++){
             mapt.put(String.valueOf(t.charAt(i)), mapt.getOrDefault(String.valueOf(t.charAt(i)), 0)+1);
         }

         for(Map.Entry<String, Integer> entry: mapt.entrySet()){
             if(!mapStr.containsKey(entry.getKey())){
                return false;
             }
             if(mapStr.containsKey(entry.getKey()) && (entry.getValue() > mapStr.get(entry.getKey()))){
                 return false;
             }
         }
         return true;
     }
     public String minWindow(String s, String t) {
         if(s.length() < t.length()){
             return "";
         }
         if(s.equals(t)){
             return t;
         }

         for(int i = t.length();i<s.length();i++){
             for(int j =0;j<s.length();j++){
                 if(j+i > s.length()){
                     break;
                 }
                 if(findSubString(s.substring(j, j+i), t)){
                     return s.substring(j, j+i);
                 }
             }
         }
               if(findSubString(s, t)){
                     return s;
                 }
         return "";
     }
 }

class ChatGptSolution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> mapt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0) + 1);
        }
        int required = mapt.size();
        int left = 0, right = 0;
        int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            if (mapt.containsKey(c) && windowCounts.get(c).intValue() == mapt.get(c).intValue()) {
                formed++;
            }
            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (mapt.containsKey(c) && windowCounts.get(c).intValue() < mapt.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

public class Infosys {
    public static void main(String[] args) {
        System.out.println("Hello, Infosys!");
    }
}
