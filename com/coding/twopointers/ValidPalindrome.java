package com.coding.twopointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(str.charAt(left)))
                left++;
            while(right > left && !Character.isLetterOrDigit(str.charAt(right)))
                right--;

            if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
