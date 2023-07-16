package DailyChallenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/* 1125. Smallest Sufficient Team

In a project, you have a list of required skills req_skills, and a list of people. The ith person people[i] contains a list of skills that the person has.

Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least one person in the team who has that skill. We can represent these teams by the index of each person.

For example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
Return any sufficient team of the smallest possible size, represented by the index of each person. You may return the answer in any order.

It is guaranteed an answer exists.

 

Example 1:

Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
Output: [0,2]
Example 2:

Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
Output: [1,2]
 

Constraints:

1 <= req_skills.length <= 16
1 <= req_skills[i].length <= 16
req_skills[i] consists of lowercase English letters.
All the strings of req_skills are unique.
1 <= people.length <= 60
0 <= people[i].length <= 16
1 <= people[i][j].length <= 16
people[i][j] consists of lowercase English letters.
All the strings of people[i] are unique.
Every skill in people[i] is a skill in req_skills.
It is guaranteed a sufficient team exists. 


*/

public class SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i)
            map.put(req_skills[i], i);
        List<Integer>[] dp = new List[1 << n];
        dp[0] = new ArrayList<>();
        
        int[] skillPerson = new int[m];
        for (int i = 0; i < m; i ++) {
            List<String> list = people.get(i);
            int val = 0;
            for (String skill : list) {
                val |= 1 << map.get(skill);
            }
            skillPerson[i] = val;
        }
        boolean[] banned = new boolean[m];
        for (int i = 0; i < m; i ++) {
            for (int j = i + 1; j < m; j ++) {
                int val = skillPerson[i] | skillPerson[j];
                if (val == skillPerson[i]) {
                    banned[j] = true;
                } else if (val == skillPerson[j]) {
                    banned[i] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if(banned[i]) continue;
            int cur_skill = skillPerson[i];
            
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] == null) continue;
                int comb = j | cur_skill;
                if (dp[comb] == null || dp[j].size() + 1 < dp[comb].size()) {
                    dp[comb] = new ArrayList<>(dp[j]);
                    dp[comb].add(i);
                }
            }
        }
        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
    }
}
