import java.util.*;

public class LongestUniqueSubstring {

    public static String longestSubstringWithoutRepeating(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0, maxLength = 0, startIndex = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= left) {
                left = charMap.get(currentChar) + 1;
            }

            charMap.put(currentChar, right);

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubstringWithoutRepeating(s)); 
    }
}
