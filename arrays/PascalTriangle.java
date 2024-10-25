package arrays;

import java.util.ArrayList;
import java.util.List;

class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        // Store the entier pascal triangle
        for (int row = 1; row <= numRows; row++) {
            ans.add(generateRow(row));
        }

        return ans;
    }

    public List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        // Calculate the rest of elements
        for (int col = 1; col < row; col++) {
            // Here the formula we are using are
            // ans * (row - col) / col
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }

        return ansRow;
    }
}

/*
 * If we are given the value of row and col and asked to find the int at that place
 * then we can use the nCr formula to calculate that,
 * nCr = n! / r! (n-r)!
 * 
 * To find the factorials we can run the loop till that number whose factorial we want
 * 
 * This is how we should calculate nCr (never run the whole loops for n and r 
 * separately, otherwise it will take lots of time)
 * 
 * int nCr(int n, int r) {
 *     long res = 1;
 *     for (int i = 0; i < r; i++) {
 *         res = res * (n - 1);
 *         res = res / (i + 1);
 *     }
 *     return res;
 * }
 */
