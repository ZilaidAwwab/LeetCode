package arrays;

import java.util.HashSet;

public class LongestConsecutive {
    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive 
     * elements sequence.
     * 
     * You must write an algorithm that runs in O(n) time.
     * 
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its 
     * length is 4.
     * 
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     * 
     * Input: nums = [1,0,1,2]
     * Output: 3
     */

    /**
     * We used a Hashset and added all the elements into that first
     * Then we started building a sequence from the beginning recording length of that
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int longest = 0;
        for (int n: set) {
            if (!set.contains(n - 1)) {
                int lenght = 1;
                while (set.contains(n + lenght)) {
                    lenght++;
                }
                longest = Math.max(longest, lenght);
            }
        }
        return longest;
    }
}
