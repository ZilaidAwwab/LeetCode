package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * Given an array of integers nums and an integer target, return indices of the two 
     * numbers such that they add up to target.
     * 
     * You may assume that each input would have exactly one solution, and you may not use 
     * the same element twice.
     * 
     * You can return the answer in any order.
     * 
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * 
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     */

    /**
     * Approach: HashMap (Two Pointers approach is right, but inefficient)
     * Here we subtract the current element from the target and then check if the subtracted
     * number exists in the hashmap, if so then we return both of them.
     * Otherwise we just add the current element in the hashmap.
     * 
     * Time: O(N)
     * Space: O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{};
    }
}
