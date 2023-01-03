package DataStructure1;
/* 242. Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

 */

public class anagram {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        for(char c:t.toCharArray()){
            arr[c-'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(arr[i] != 0) 
                return false;
        }
        return true;
        
    }
    
}
