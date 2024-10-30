package arrays;

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int maxValue = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0 ;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while(sum >= target) {
                maxValue = Math.min(maxValue, i-left + 1);
                sum -= nums[left++];
            }
        }
        return maxValue == Integer.MAX_VALUE ? 0 : maxValue;
    }
}
