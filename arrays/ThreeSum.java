package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums
     * [k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * 
     * Notice that the solution set must not contain duplicate triplets.
     * 
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation: 
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     * 
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     * 
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     */

    /**
     * Approach: Two Pointers
     * Fixing the first pointers and then applying the two pointers approach.
     * Sorting the array first, and then increasing the first pointer in case the 
     * number was smaller than 0, and decreasing the second pointer (at last 
     * position), if the sum was coming greater than 0.
     * 
     * Time: O(N^2)
     * Space: O(N)
     * 
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // This is to avoid duplication and unnecesary checks if the next number is same as previous
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;
    
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];
    
                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    answer.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
    
                    // checking an edge case where i and j have same elements, we push j only until it is less than k, otherwise we stop when j == k
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return answer;
    }
}
