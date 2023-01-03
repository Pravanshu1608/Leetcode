package DataStructure1;
/* 387. First unique character in a string
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.

 */

public class firstUniqueChar {
    public int firstUniqChar(String s) {
        /*
        HashMap<Character, Integer> map = new HashMap();
        for(int i=0; i<s.length(); i++){
            char current=s.charAt(i);
            if(!map.containsKey(current)){
                map.put(current, i);
            } else{
                map.put(current, -1);
            }
        }
        int min=Integer.MAX_VALUE;
        for(char c:map.keySet()){
            if(map.get(c)>-1 && map.get(c)<min){
                min=map.get(c);
            }
        }
        */
        int min=Integer.MAX_VALUE;
        for(char c='a'; c<='z'; c++){
            int start=s.indexOf(c);
            int last=s.lastIndexOf(c);
            if(start != -1 && start==last){
                min=Math.min(min,start);
            }
        }

        return min==Integer.MAX_VALUE ? -1 : min;
    }
    
}
