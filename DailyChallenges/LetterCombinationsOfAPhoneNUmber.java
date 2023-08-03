package DailyChallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].


*/

public class LetterCombinationsOfAPhoneNUmber {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return Collections.emptyList();
        List<String> ans = new ArrayList();
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve("", digits, ans, map);
        return ans;
    }
    public void solve(String str, String digits, List<String> ans, String[] map){
        if(digits.isEmpty()){
            ans.add(str);
        } else{
            String letters = map[digits.charAt(0) - '2'];
            for(char letter:letters.toCharArray()){
                solve(str + letter, digits.substring(1), ans, map);
            }
        }
    }
}
