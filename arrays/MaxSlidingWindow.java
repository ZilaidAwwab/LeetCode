package arrays;

public class MaxSlidingWindow {
    /**
     * You are given an array of integers nums, there is a sliding window of size k which 
     * is moving from the very left of the array to the very right. You can only see the 
     * k numbers in the window. Each time the sliding window moves right by one position
     * 
     * Return the max sliding window.
     * 
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation: 
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * 
     * Input: nums = [1], k = 1
     * Output: [1]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        int[] ans = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            if (i % k == 0) lmax[i] = nums[i];
            else lmax[i] = Math.max(lmax[i - 1], nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || (i + 1) % k == 0) rmax[i] = nums[i];
            else rmax[i] = Math.max(rmax[i + 1], nums[i]);
        }

        for (int i = 0; i <= n - k; i++) {
            ans[i] = Math.max(rmax[i], lmax[i + k - 1]);
        }
        return ans;
    }
}
