package arrays;

public class Trap {
    /**
     * Given n non-negative integers representing an elevation map where the width of 
     * each bar is 1, compute how much water it can trap after raining.
     * 
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,
     * 1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are 
     * being trapped.
     * 
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     */

    /**
     * Approach: 1
     * Find the next big element in the array (But fails in some cases)
     * 
     * Approach: 2
     * Find the min between left and right extreme, and then subtract the current element from that
     * 
     * Time: O(N)
     * Space: O(1)
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int total = 0;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                total += leftMax - height[left];
                left++;
            } else {
                total += rightMax - height[right];
                right--;
            }
        }
        return total;  
    }
}
