package arrays;

import java.util.List;
import java.util.ArrayList;

public class FindDuplicates {
    /**
     * Given an integer array nums of length n where all the integers of nums are in 
     * the range [1, n] and each integer appears at most twice, return an array of 
     * all the integers that appears twice.
     * 
     * You must write an algorithm that runs in O(n) time and uses only constant 
     * auxiliary space, excluding the space needed to store the output.
     * 
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [2,3]
     * 
     * Input: nums = [1,1,2]
     * Output: [1]
     * 
     * Input: nums = [1]
     * Output: []
     */

    /**
     * Approach: 1 (Hashtable)
     * This could easily be solved with hashtable (map or set)
     * But using that was costing us O(N) space where we were only tasked to utilize O(1)
     * 
     * Approach: 2 
     * Marking the elements negative by approaching them via index of array
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]);
            if (nums[temp - 1] < 0) {
                duplicates.add(temp);
            } else {
                nums[temp - 1] *= -1;
            }
        }
        return duplicates;
    }
}
