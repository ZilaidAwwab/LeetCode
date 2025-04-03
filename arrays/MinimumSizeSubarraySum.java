package arrays;

class MinimumSizeSubarraySum {
    /**
     * Given an array of positive integers nums and a positive integer target, return 
     * the minimal length of a subarray whose sum is greater than or equal to target. 
     * If there is no such subarray, return 0 instead.
     * 
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem 
     * constraint.
     * 
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     * 
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     */

    /**
     * Approach: Sliding Window
     * Adding all the nums from the start of the array, and each time checking if the 
     * sum is equal or greater than target, then we will start subtracting the nums 
     * from the left until the sum is still greater or equal to target. Then at the 
     * end we will return the number of elements in the array that were used to give 
     * us the sum value equal to the target
     * 
     * Time: O(N)
     * Space: O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int maxValue = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0 ;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while(sum >= target) {
                maxValue = Math.min(maxValue, i-left + 1);
                sum -= nums[left++];
            }
        }
        return maxValue == Integer.MAX_VALUE ? 0 : maxValue;
    }
}
