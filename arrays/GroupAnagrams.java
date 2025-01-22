package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer 
     * in any order.
     * 
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * Explanation:
     * There is no string in strs that can be rearranged to form "bat".
     * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
     * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form 
     * each other.
     * 
     * Input: strs = [""]
     * Output: [[""]]
     * 
     * Input: strs = ["a"]
     * Output: [["a"]]
     */

    /**
     * Steps:
     * 1. Convert every String(word) in the array to an array of itself and sort that
     * 2. Then make a String of that sorted array
     * 3. Check if that string is present in the hashmap
     * 4. If not then add that with a value of freshly created array
     * 5. If present or not, add the word from which that sorted string is made into that array
     * 6. Return all the values of the hashmap i-e: arrays
     * 
     * Time: O(n * K log K)
     * Space: O(n * k)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word: strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWords = new String(chars);

            if (!map.containsKey(sortedWords)) {
                map.put(sortedWords, new ArrayList<>());
            }
            map.get(sortedWords).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
