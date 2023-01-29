package DataStructure2;

/* 205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.

*/

public class isomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] char1 = new int[256];
        int[] char2 = new int[256];

        for(int i=0; i<s.length(); i++){
            if(char1[s.charAt(i)] != char2[t.charAt(i)])
                return false;
            char1[s.charAt(i)] = i + 1;
            char2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
