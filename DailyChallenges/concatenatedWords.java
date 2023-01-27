package DailyChallenges;

/* 472. Concatenated Words

Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

 

Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Example 2:

Input: words = ["cat","dog","catdog"]
Output: ["catdog"]
 

Constraints:

1 <= words.length <= 104
1 <= words[i].length <= 30
words[i] consists of only lowercase English letters.
All the strings of words are unique.
1 <= sum(words[i].length) <= 105

*/

public class concatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (dfs(word, 0, set, 0)) res.add(word);
        }
        return res;
    }

    // check word.substring(index) 
    private boolean dfs(String word, int index, Set<String> set, int num) {
        if (index == word.length()) {
            if (num >= 2) return true;
            else return false;
        }
        for (int i = index + 1; i <= word.length(); i++) {
            String next = word.substring(index, i);
            if (set.contains(next)) {
                num++;
                boolean flag = dfs(word, i, set, num);
                if (flag) return true;
                num--;
            }
        }
        return false;
    }
}
