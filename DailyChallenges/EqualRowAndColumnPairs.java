package DailyChallenges;

/* 2352. Equal Row and Column Pairs

Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 

Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105

*/

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        /* ArrayList<Integer> list1 = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList();
        int rows = grid.length;
        int cols = grid[0].length;
        int count=0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                list1.add(grid[i][j]);
            }
            for(int k=0; k<cols; k++){
                for(int l=0; l<rows; l++){
                    list2.add(grid[l][k]);
                }
                if(list1.equals(list2)){
                    count++;
                }
                list2.clear();
            }
            list1.clear();
        }
        return count;

        */

        int count=0;
        int n=grid.length;
        int[][] grid2 = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid2[j][i] = grid[i][j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(Arrays.equals(grid[i], grid2[j])){
                    count++;
                }
            }
        }
        return count;
    }
}
