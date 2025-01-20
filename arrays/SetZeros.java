package arrays;

class SetZeroes {
    /**
     * Given an m x n integer matrix matrix, if an element is 0, set its entire 
     * row and column to 0's.
     * 
     * You must do it in place.
     * 
     * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * Output: [[1,0,1],[0,0,0],[1,0,1]]
     * 
     * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     */
    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        // This is to find the length of the nested arrays
        int m = matrix[0].length; 
        
        int col0 = 1;

        // Traverse the matrix and mark elements of 1st row and col as 0, if the given element is 0
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    // Mark the ith element of row zero
                    matrix[i][0] = 0;

                    // Mark the jth element of col zero
                    if(j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        // Step 2: Making the elements 0 if their corresponding 1st row or column element is 0
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] != 0) {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // In 3rd and 4th step we are only checking if the 1st element of 1st row, and col is 0, if so then we make that whole row 0

        // Step 3: Making the 1st row 0 if first element of the row is 0
        if(matrix[0][0] == 0) {
            for(int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Making the 1st col 0 if first element of the col is 0
        if(col0 == 0) {
            for(int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
