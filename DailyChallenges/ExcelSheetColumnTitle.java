package DailyChallenges;

/* 168. Excel Sheet Column Title

Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"
 

Constraints:

1 <= columnNumber <= 231 - 1

*/

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while(columnNumber>0){
            int remainder = (columnNumber - 1) % 26;
            char ch = (char) (remainder + 'A');
            result.insert(0, ch);
            columnNumber = (columnNumber - 1) / 26;
        }

        return result.toString();
    }
}
