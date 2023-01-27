package DataStructure2;

/* 139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

*/

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //approach-1
        /*
        boolean[] ans = new boolean[s.length() + 1];
        ans[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(ans[j] && wordDict.contains(s.substring(j, i))){
                    ans[i] = true;
                    break;
                }
            }
        }
        return ans[s.length()];
        */

        // approach-2
        /*
        HashSet<String> set =new HashSet<>(wordDict);

        int n=s.length();

        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
        */

        //approach-3
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++){
            if(!dp[i])continue;
            String tmp = s.substring(i);
            for (String w: wordDict){
                if (tmp.startsWith(w)){
                    dp[i + w.length()] = true;
                }
            }
        }
        return dp[n];
    }
}
