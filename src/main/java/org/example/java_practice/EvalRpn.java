package org.example.java_practice;

import java.util.Stack;

public class EvalRpn {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        int res = 0;
        if(tokens.length == 1){
            res = Integer.valueOf(tokens[0]);
        }
        for(int i =0;i<tokens.length;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                operands.push(Integer.valueOf(tokens[i]));
            } else {
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                if(tokens[i].equals("+")){
                    res = operand2 + operand1;
                    operands.push(res);
                } else if(tokens[i].equals("-")){
                    res = operand2 - operand1;
                    operands.push(res);
                } else if(tokens[i].equals("*")){
                    res = operand2 * operand1;
                    operands.push(res);
                } else if(tokens[i].equals("/")){
                    res = operand2 / operand1;
                    operands.push(res);
                }
            }
        }
        return res;
    }
}
