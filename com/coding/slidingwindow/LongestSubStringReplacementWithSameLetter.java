package com.coding.slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringReplacementWithSameLetter {
    public static int findLongestSubStringLength(String string, int k) {
        // Declare a Character Map
        Map<Character, Integer> characterCount = new HashMap<>();
        int result = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
            char end = string.charAt(windowEnd);
            characterCount.put(end, (characterCount.getOrDefault(end, 0) + 1));

            while ((windowEnd - windowStart + 1) - Collections.max(characterCount.values()) > k) {
                char startChar = string.charAt(windowStart);
                characterCount.put(startChar, characterCount.get(startChar) - 1);
                windowStart = windowStart + 1;
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubStringLength("aabccbb", 2));
        System.out.println(findLongestSubStringLength("abbcb", 1));
        System.out.println(findLongestSubStringLength("abccde", 1));
        System.out.println(findLongestSubStringLength("", 1));
    }
}
