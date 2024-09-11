package org.example.java_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int res[] = new int[len];
        for(int i=len-1;i>=0;i--){
            stack.push(temperatures[i]);
            res[i] = 0;
        }
        int j=0;
        while (!stack.empty()){
            List<Integer> temp = new ArrayList<>();
            int top = stack.pop();
            while(!stack.empty()){
                if(stack.peek() <= top){
                    temp.add(stack.pop());
                } else {
                    res[j] = temp.size() + 1;
                    break;
                }
            }
            j++;
            for(int i=temp.size()-1;i>=0;i--){
                stack.push(temp.get(i));
            }
        }
        return res;
    }
}
