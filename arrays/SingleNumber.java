package arrays;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    /**
     * Given a non-empty array of integers nums, every element appears twice except 
     * for one. Find that single one.
     * 
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     * 
     * Input: nums = [2,2,1]
     * Output: 1
     * 
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     */

    /**
     * Approach: 1 (Use HashMap)
     * Put all the elements in a HashMap as a key, and their occurances as a value
     * Then traverse the hashmap and find the element whose value is 1, and return its key
     * 
     * Time: O(n)
     * Space: O(n)
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int minFreqElement = 0;

        // Step: 1 (Count Occurances)
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step: 2 (Find the one with frequency 1)
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (entry.getValue() == 1) {
                minFreqElement = entry.getKey();
            }
        }
        return minFreqElement;
    }

    /**
     * Approach: 2 (Bit Manipulation)
     * Here we used XOR, since XOR of 2 identical numbers give 0
     * So, we will XOR the whole array, and the number that is left, will be required
     * 
     * Time: O(n)
     * Space: (1)
     */
    public int singleNumber2(int[] nums) {
        int minFreqElement = 0;
        for (int num: nums) {
            minFreqElement ^= num;
        }
        return minFreqElement;
    }
}
