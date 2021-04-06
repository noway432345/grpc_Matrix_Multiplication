package com.example.grpc.converter;

import java.util.Arrays;

public class ConvertMatrix {
 
    public static int[][] transformM(String matrixString) {
        return convertBackToArray(matrixString);
    }

  
    
    public static int[][] convertBackToArray(String str) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                row++;
            }
        }
        row--;
        for (int i = 0;; i++) {
            if (str.charAt(i) == ',') {
                col++;
            }
            if (str.charAt(i) == ']') {
                break;
            }
        }
        col++;

        int[][] out = new int[row][col];

        str = str.replaceAll("\\[", "").replaceAll("\\]", "");

        String[] s1 = str.split(", ");

        int j = -1;
        for (int i = 0; i < s1.length; i++) {
            if (i % col == 0) {
                j++;
            }
            out[j][i % col] = Integer.parseInt(s1[i]);
        }
        return out;
    }
    
    public static String convertToString(int[][] matrix) {
        return Arrays.deepToString(matrix);
    }
}
