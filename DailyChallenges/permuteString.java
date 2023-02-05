package DailyChallenges;

/* 567. Permutation in String

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.


*/

public class permuteString {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1>l2) return false;

        int[] count = new int[26];
        for (int i = 0; i < l1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;
        
        for (int i = l1; i < l2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - l1) - 'a']++;
            if (allZero(count)) return true;
        }
        
        return false;
    }

    private boolean allZero(int[] count){
        for(int i=0; i<26; i++){
            if(count[i]!=0) return false;
        }
        return true;
    }
}
