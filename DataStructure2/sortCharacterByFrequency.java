package DataStructure2;

/* 451. Sort Characters By Frequency

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.

*/

public class sortCharacterByFrequency {
    public String frequencySort(String s) {
        int[] counter = new int['z' - '0' + 1];
        for (int i = 0; i < s.length(); i++)
            counter[s.charAt(i) - '0']++;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < counter.length; i++)
            list.add(new int[]{i, counter[i]});

        Collections.sort(list, (a, b) -> b[1] - a[1]);

        StringBuilder sb = new StringBuilder();
        for(int[] element : list){
            char c = (char)('0' + element[0]);
            for (int i = 0; i < element[1]; i++) sb.append(c);
        }
        return sb.toString();
    }
}
