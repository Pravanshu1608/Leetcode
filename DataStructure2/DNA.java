package DataStructure2;

/* 187. Repeated DNA Sequences

The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'.

*/

public class DNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList();
        if(s.length() <= 10) return ans;

        Map<String, Integer> map = new HashMap();
        int i=0, j=10;
        while(j<=s.length()){
            String substr = s.substring(i++, j++);
            map.put(substr, map.getOrDefault(substr, 0) + 1);

            if(map.get(substr)>1 && !ans.contains(substr)) ans.add(substr);
        }
        return ans;
    }
}
