package DataStructure2;

/* 59. Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20

*/

public class spiralMatrixII {
    public int[][] generateMatrix(int n) {
        int r1=0, r2=n-1;
        int c1=0, c2=n-1;

        int[][] arr = new int[n][n];
        int val=1;

        while(r1<=r2 && c1<=c2){

            //moving right
            for(int c=c1; c<=c2; c++) arr[r1][c]=val++;
            //moving down
            for(int r=r1+1; r<=r2; r++) arr[r][c2]=val++;
            //moving right to left
            //move up
            if(r1<r2 && c1<c2){
                //move right to left
                for(int c=c2-1; c>c1; c--) arr[r2][c]=val++;
                //move up
                for(int r=r2; r>r1; r--) arr[r][c1]=val++;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return arr;
    }
}
