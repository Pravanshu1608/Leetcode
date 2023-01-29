package DataStructure2;

/* 290. Word Pattern

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 

Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.

*/

public class wordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> map = new HashMap();
        String[] x = new String[26];
        String[] y = s.split(" ");
        if(pattern.length()!=y.length){
            return false;
        }
        if(pattern.length()==1)
            return true;

        for(int i=0; i<y.length; i++){
            char ch = pattern.charAt(i);
            if(map.get(y[i])!=null){
                if(map.get(y[i])!=ch)
                    return false;
            } else{
                if(x[ch-'a']!=null)
                    return false; 
            }
            x[ch-'a']=y[i];
            map.put(y[i], ch);
        }
        return true;  
    }
}
