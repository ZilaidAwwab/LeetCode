package arrays;

public class MissingNumber {
    /**
     * Given an array nums containing n distinct numbers in the range [0, n], return 
     * the only number in the range that is missing from the array.
     * 
     * Input: nums = [3,0,1]
     * Output: 2
     * 
     * Input: nums = [9,6,4,2,3,5,7,0,1]
     * Output: 8
     */

     /**
      * Approach: 1 (Regular Looping)
      * Calculate till the sum of nums, equivalent to the length of array 
      * (0 => n) [3, 0, 1] = 0, 1, 2, 3 (It's n+1, becasue one number is missing)
      * Calculate the sum of elements present in the array
      * Subtract the totalSum from the CurrentSum
      * totalSum = 0+1+2+3 = 6
      * CurrentSum = 3+0+1 = 4
      * 6-4 = 2 (Answer)
      */
    public int missingNumber(int[] nums) {
        int totalSum = 0;
        int CurrentSum = 0;
        for (int i = 0; i <= nums.length; i++) {
            totalSum += i;
        }
        for (int num: nums) {
            CurrentSum += num;
        }
        return totalSum - CurrentSum;
    }

    /**
     * Approach: 2 (Bit Manipulation)
     * Here we are using XOR (As XOR of 2 same number will be 0)
     * So, we XOR each number with itself
     */
    public int missingNumber2(int[] nums) {
        int allNums = 0;
        int arrayNums = 0;
        for (int i = 0; i <= nums.length; i++) {
            allNums ^= i;
        }
        for (int j = 0; j < nums.length; j++) {
            arrayNums ^= nums[j];;
        }
        return (allNums)^(arrayNums);
    }
}
