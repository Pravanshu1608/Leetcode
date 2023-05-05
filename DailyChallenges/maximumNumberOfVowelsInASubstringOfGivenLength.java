package DailyChallenges;

/* 1456. Maximum Number of Vowels in a Substring of Given Length

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length

*/

public class maximumNumberOfVowelsInASubstringOfGivenLength {
    public static boolean check(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }

    public int maxVowels(String s, int k) {
        int max = Integer.MIN_VALUE;
        int maxCount = 0;

        for(int i = 0; i<k; i++){
            if(check(s.charAt(i)))
                maxCount++;
        }
        max = maxCount;

        for(int i = k; i<s.length(); i++){
            if(check(s.charAt(i-k)))
                maxCount--;
            if(check(s.charAt(i)))
                maxCount++;
            max = Math.max(max, maxCount);
        }

        return max;
    }
}
