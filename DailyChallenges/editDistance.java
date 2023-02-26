package DailyChallenges;

/* 72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.

*/

public class editDistance {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        
        // Base cases
        // Initializing First row
        for(int i=0; i <= l2; i++)
            dp[0][i] = i;        
        // Initializing First col
        for(int i=0; i <= l1; i++)
            dp[i][0] = i;
        
        for(int i=1; i <= l1; i++){
            for(int j=1; j <= l2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], // replace
                                            Math.min(dp[i-1][j], // delete
                                                     dp[i][j-1]) // insert
                                           ); 
            }
        }
        
        return dp[l1][l2];
    }
}
