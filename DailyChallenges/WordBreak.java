package DailyChallenges;

import java.util.List;

public class WordBreak {
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
