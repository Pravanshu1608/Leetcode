package DailyChallenges;

/* 438. Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.

*/

public class anagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList();
        int n = s.length();
        int m = p.length();
        if(n<m) return ans;

        int[] arr_s = new int[26];
        int[] arr_p = new int[26];
        for(int i=0; i<m; i++){
            arr_s[s.charAt(i) - 'a']++;
            arr_p[p.charAt(i) - 'a']++;
        }
        for(int i=0; i<=n-m; i++){
            boolean flag = true;
            for(int j=0; j<26; j++){
                if(arr_s[j]!=arr_p[j]){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                ans.add(i);
            }
            arr_s[s.charAt(i) - 'a']--;
            if(i+m < n){
                arr_s[s.charAt(i+m) - 'a']++;
            }
        }
        return ans;
    }
}
