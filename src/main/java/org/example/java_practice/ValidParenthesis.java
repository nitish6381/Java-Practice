package org.example.java_practice;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() != '('){
                    return false;
                }
                stack.pop();
            } else if(s.charAt(i) == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() != '{'){
                    return false;
                }
                stack.pop();
            } else if(s.charAt(i) == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }

        if(stack.size() == 0){
            return true;
        }
        return false;

    }
}
