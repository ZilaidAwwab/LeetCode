package arrays;

public class FindDuplicate {
    /**
     * Given an array of integers nums containing n + 1 integers where each integer is 
     * in the range [1, n] inclusive.
     * 
     * There is only one repeated number in nums, return this repeated number.
     * 
     * You must solve the problem without modifying the array nums and using only constant extra space.
     * 
     * Input: nums = [1,3,4,2,2]
     * Output: 2
     * 
     * Input: nums = [3,1,3,4,2]
     * Output: 3
     */

    /**
     * Approach: 1 (Using 2 Pointers)
     * This one is in-efficient and shows Time Limit Exceeded
     */
    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    /**
     * Approach: 2 (Using Fast and Slow Pointers (Hare and Tortoise Algorithm))
     * Fast and slow pointers means that iterating the indexes based on the number at that point
     * Here we are treating the array as linked list
     * 
     * Time: O(N)
     * Space: O(1)
     */
    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // This loop detects the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // After finding the coinciding number we reset the fast pointer to 0, while leaving the slow pointer to where it was
        fast = nums[0];

        // This loop locates the entrance of the cycle
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
