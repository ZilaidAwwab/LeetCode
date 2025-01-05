package arrays;

public class ProductExceptSelf {
    /**
     * Given an integer array nums, return an array answer such that answer[i] 
     * is equal to the product of all the elements of nums except nums[i].
     * 
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * 
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     * 
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     * 
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     */

    /**
     * Here we have to multiply all the left and right nums of an element except that.
     * [1, 2, 3, 4]
     * For first place we will be multiplying 2 * 3 * 4 (24)
     * For Second place we will be multiplying 1 * 3 * 4 (12)
     * For Third place we will be multiplying 1 * 2 * 4 (8)
     * For Forth place we will be multiplying 1 * 2 * 3 (6)
     * 
     * Time: O(N)
     * Space: O(N)
     */

    /**
     * Approach: 1 (Brute Force) (Time Limit exceeding failure)
     * Multiplied every number of that array with every other number, skipping when i == j
     * This took O(N^2) time
     */
    public int[] productExceptSelf(int[] nums) {
        int multiplier = 1;
        int[] answer = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            multiplier = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                multiplier *= nums[j];
            }
            answer[i] = multiplier;
        }
        return answer;
    }

    /**
     * Approch: 2 (Using Prefix and Suffix Product)
     * Store the product of all the prefix elements in one array
     * Store the product of all the suffix element in other array
     * Multiply them both and return 
     */
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] answer = new int[n];

        // Since we are multiplying the first element in the prefix array, and last element in the suffix array in the first iteration, and that are null initially, that's why we have to make their values 1, so that other numbers could be multiplied with them.
        prefix[0] = 1;
        suffix[n-1] = 1;

        // Multiply all the prefixes of that array from i in position i and store in i
        // Here the loop runs till i < n and not i <= n becasue nums[i] don't have to be part of product
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        
        // Multiply all the suffixes of that array from position i and store in i
        for (int i = n-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * suffix[i];
        }
        return answer;
    }
}
