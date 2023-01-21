package DataStructure1;

/* 131. Palindrome Partitioning

Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.

*/

public class palindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        helper(s, new ArrayList(), ans);
        return ans;
    }

    void helper(String s, List<String> currlist, List<List<String>> ans){
        if(s.isEmpty()){
            ans.add(currlist);
        }
        for(int i=1; i<=s.length(); i++){
            String left = s.substring(0, i);
            String right = s.substring(i);
            if(isPalindrome(left)){
                List<String> copylist = new ArrayList(currlist);
                copylist.add(left);
                helper(right, copylist, ans);
            }
        }
    }

    boolean isPalindrome(String s){
        int l=0, r=s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
