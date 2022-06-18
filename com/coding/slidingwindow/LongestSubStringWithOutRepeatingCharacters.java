package com.coding.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithOutRepeatingCharacters {
    public int findLengthOfLongestRepeatingCharacters(String s) {
        if(s == null || s.length() == 0) return 0;

        Set<Character> window = new HashSet<>();
        int left = 0, right = 0;
        int longest = 0;

        for(Character c : s.toCharArray()) {
            while(window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubStringWithOutRepeatingCharacters sol = new LongestSubStringWithOutRepeatingCharacters();
        System.out.println(sol.findLengthOfLongestRepeatingCharacters("abcabcbb"));
    }
}
