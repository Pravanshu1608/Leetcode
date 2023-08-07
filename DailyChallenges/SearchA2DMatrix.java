package DailyChallenges;

/* 74. Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

*/

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int row=matrix.length;
        int col=matrix[0].length;

        int low=0, high=row*col -1;
        while(low<=high){
            int midpoint=low + (high-low)/2;
            int midElement=matrix[midpoint/col][midpoint%col];
            if(midElement==target) return true;
            else if(midElement<target) low=midpoint+1;
            else if(midElement>target) high=midpoint-1;
        }
        return false;
    }
}
