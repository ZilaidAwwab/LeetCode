package strings;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    /**
     * Given a string s, find the length of the longest substring without duplicate 
     * characters.
     * 
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * 
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * 
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a 
     * substring.
     */

    /**
     * Approach: Sliding Window
     * Mainting two pointers to mimic a window, between these two points are the unique
     * characters of the strings (saved in a hashset), and as we counter a duplicate as
     * we move right, we remove the char, which is pointed by the left pointer and 
     * increase the left pointer
     * 
     * Time: O(N)
     * Space: O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int charLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(right));
                left++;
            }
            set.add(s.charAt(right));
            charLength = Math.max(charLength, right - left + 1);
        }
        return charLength;
    }
}
