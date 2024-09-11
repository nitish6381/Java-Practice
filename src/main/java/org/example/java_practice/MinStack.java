package org.example.java_practice;

import java.util.ArrayList;

class MinStack {
    ArrayList<Integer> arr = new ArrayList<>();
    public MinStack() {

    }

    public void push(int val) {
        arr.add(val);
    }

    public void pop() {
        arr.remove(arr.size()-1);
    }

    public int top() {
        return arr.get(arr.size()-1);
    }

    public int getMin() {
        int min = arr.get(0);
        for(int i=1;i<arr.size();i++){
            if(arr.get(i) < min){
                min = arr.get(i);
            }
        }
        return min;
    }
}
