package org.example.java_practice;

import java.util.*;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            stack.push(position[i]);
        }
        while(!stack.empty()){
            int pos = stack.pop();
            double time = (double)(target - pos) / (double)map.get(pos);
            List<Integer> temp = new ArrayList<>();
            while(!stack.empty()){
                if((double)(target - stack.peek()) / (double)map.get(stack.peek()) <= time){
                    stack.pop();
                }else{
                    temp.add(stack.peek());
                    stack.pop();
                }
            }
            for(int i = temp.size() -1; i >= 0; i--){
                stack.push(temp.get(i));
            }
            res++;
        }
        return res;
    }
}
