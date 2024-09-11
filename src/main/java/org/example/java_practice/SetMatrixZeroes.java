package org.example.java_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SetMatrixZeroes {

    public int[][] makeZeroes(int[][] matrix, int row, int col){
        for(int i=0;i<matrix.length;i++){
            matrix[i][col] = 0;
        }
        for(int j=0;j<matrix[0].length;j++){
            matrix[row][j] = 0;
        }
        return matrix;
    }
    public void setZeroes(int[][] matrix) {
        List<int[]> zeroes = new ArrayList<>();
       int[][] copy = new int[matrix.length][matrix[0].length];
       for(int i =0;i<=matrix.length;i++){
           for(int j=0;j<=matrix[0].length;j++){
               if(matrix[i][j] == 0){
                     zeroes.add(new int[]{i,j});
               } else {
                     copy[i][j] = matrix[i][j];
               }
           }
        }
        for(int[] zero:zeroes){
            copy = makeZeroes(copy,zero[0],zero[1]);
        }
    }

//    public List<Integer> spiralOrder(int[][] matrix) {
//
//    };

    public boolean isPalindrome(String s) {
        String str = Arrays.toString(s.split("[^a-zA-Z0-9]"));
        str = str.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }

        return true;
    }

    public static int longestValidParentheses(String s) {
        int count = 0;
        int maxCount = 0;
        Stack<String> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            String c = String.valueOf(s.charAt(i));
            if(c.equals("(") || c.equals("[") || c.equals("{")){
                stack.push(c);
            } else if(c.equals(")") || c.equals("]") || c.equals("}")){
                if(stack.isEmpty()){
                    continue;
                }
                String top = stack.peek();
                if((c.equals(")") && top.equals("(")) || (c.equals("]") && top.endsWith("[")) || (c.equals("}") && top.equals("{"))){
                    stack.pop();
                    count+=2;
                } else {
                    if(count > maxCount){
                        maxCount = count;
                    }
                    count = 0;
                    stack.clear();
                }
            } else if(!stack.isEmpty()) {
                stack.pop();
            } else{
                continue;
            }
        }
        return count;
    }

    public static void main(String[] args){
        String str = "()(()";
        System.out.println(longestValidParentheses(str));
    }

}
