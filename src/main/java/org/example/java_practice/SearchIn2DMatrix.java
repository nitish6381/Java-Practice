package org.example.java_practice;

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
      boolean res = false;
        if(matrix.length == 0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        if(n == 0)
            return res;
        int temp = 0;
        if(m==1) {
            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == target)
                    return true;

            }
        }
        int left =0;
        int right= n -1;
        if(n == 1){
            for(int i = 0; i < m; i++){
                if(matrix[i][0] == target)
                    return true;
            }
        }
        if(n == 2){
            for(int i = 0; i < m; i++){
                if(matrix[i][0] == target)
                    return true;
            }
            for(int i = 0; i < m; i++){
                if(matrix[i][1] == target)
                    return true;
            }
        }
        for(int i = 0; i < m; i++){
            if(matrix[i][0] <= target && matrix[i][n-1] >= target){
                temp = i;
                break;
            }
        }
        while (left<=right){
            int mid = left + (right - left) / 2;
            if(matrix[temp][mid] == target)
                return true;
            else if(matrix[temp][mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
      return false;
    }
}
