package arrays;

import java.util.HashMap;

public class SubarraySum {
    /**
     * Given an array of integers nums and an integer k, return the total number of subarrays 
     * whose sum equals to k.
     * 
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * 
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     * 
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     */

    /**
     * Approach: HashMap
     * We are adding the elements of array and checking if target - sum is present in the 
     * hashmap, if so then it means that this sums up to the target, and we increment the 
     * subarrays number that sums up to the target
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> subNum = new HashMap<>();
        subNum.put(0, 1);
        int total = 0, count = 0;

        for (int n: nums) {
            total += n;

            if (subNum.containsKey(total - k)) {
                count += subNum.get(total - k);
            }
            subNum.put(total, subNum.getOrDefault(total, 0) + 1);
        }
        return count;
    }
}
