package org.example.java_practice;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i = 0;i<t.length();i++){
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0)+1);
        }

        if(map.size() != map1.size()){
            return false;
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            Integer mapValue = entry.getValue();
            Integer map1Value = map1.get(entry.getKey());
            if(!mapValue.equals(map1Value)){
                return false;
            }
        }
        return true;
    }
}
