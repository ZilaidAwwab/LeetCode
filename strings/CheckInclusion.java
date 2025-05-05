package strings;

import java.util.Arrays;

public class CheckInclusion {
    /**
     * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or 
     * false otherwise.
     * 
     * In other words, return true if one of s1's permutations is the substring of s2.
     * 
     * Input: s1 = "ab", s2 = "eidbaooo"
     * Output: true
     * Explanation: s2 contains one permutation of s1 ("ba").
     * 
     * Input: s1 = "ab", s2 = "eidboaoo"
     * Output: false
     * 
     */

    /**
     * Appraoch: 1 (Hashmap)
     * This problem could be done in 26.n if we use Hashmap (Easy approach)
     * 
     * Approach: 2 (Sliding Window)
     * First we will check for the edge case.
     * 1. If the size of 1st string is greater than 2nd, then return fasle
     * 2. If 2nd is empty, then also false.
     * 3. If 1st is empty, then its automatically true.
     * 
     * Time: O(N)
     * Space: O(1)
     */

    // We are looking for String 1 somewhere inside String 2
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length() || s2.length() == 0) return false;
        if (s1.length() == 0) return true;

        int x = s1.length(), y = s2.length();

        // Here the length is 26, becasue we have 26 alphabets, and we want to check for every single one
        int[] array1 = new int[26];
        int[] array2 = new int[26];
        
        for (int i = 0; i < x; i++) {
            // array1: freq of a = 1, b = 1 → [1, 1, 0, 0, ..., 0]
            array1[s1.charAt(i) - 'a']++;
            // array2: freq of e = 1, i = 1 → [0, 0, ..., 1 (at 'e'), ..., 1 (at 'i')]
            array2[s2.charAt(i) - 'a']++;
        }

        // Checking if arrays are equal (Since we want to have window of size equal to 
        // the size of 1st string, becasue that's what are are searching for)
        for (int i = x; i < y; i++) {
            if (Arrays.equals(array1, array2)) {
                return true;
            }
            array2[s2.charAt(i-x) - 'a']--; // Remove the leftmost char from the window
            array2[s2.charAt(i) - 'a']++; // Add the new rightmost char to the window
        }
        if (Arrays.equals(array1, array2)) return true;
        else return false;
    }
}
