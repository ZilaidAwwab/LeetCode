package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindDisappearedNumbers {
    /**
     * Given an array nums of n integers where nums[i] is in the range [1, n], 
     * return an array of all the integers in the range [1, n] that do not appear in nums.
     * 
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [5,6]
     * 
     * Input: nums = [1,1]
     * Output: [2]
     */

    /**
     * Approach: 1
     * First we added all the elements of the given array in a hashset
     * Then we looked up in the Hashset from 1 to n (length of the given array)
     * Then added the missing numbers from the range, in an Array
     * The use of extra hashset cost us extra O(n) space
     * 
     * Time: O(n)
     * Space: O(n)
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!(set.contains(i))) missingNumbers.add(i);
        }
        return missingNumbers;
    }

    /**
     * Approach: 2 (Cyclic Sort)
     * We'll iterate over the array and mark the data at indexes as negative
     * At the end the index whose data in unmarked (positive), will be our missing data
     */
    public List<Integer> findDisappearedNumber2(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        // Mark the index as visited by negating the value at that index
        for (int num: nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) nums[index] = -nums[index];
        }

        // The indices with positive numbers are the missing ones
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) missingNumbers.add(i + 1);
        }
        return missingNumbers;
    }
}
