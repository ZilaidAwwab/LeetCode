package arrays;

import java.util.HashSet;

class ContainsDuplicate {
    /**
     * Given an integer array nums, return true if any value appears at least twice in the 
     * array, and return false if every element is distinct.
     * 
     * Input: nums = [1,2,3,1]
     * Output: true
     * 
     * Input: nums = [1,2,3,4]
     * Output: false
     */

     /**
      * Approaches
      * Brute Force (2 pointers direct) (n^2)
      * Optimized (Sorting (log n), then 2 pointers) (n log n)
      * Optimal (Using Hashmap) (n)
      */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
