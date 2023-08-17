package DailyChallenges;

/* 542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.

*/

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int rows = mat.length;
        int cols = mat[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
        
        int length = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            length++;
            while (size-- > 0) {
                int[] front = q.poll();
                int r = front[0];
                int c = front[1];
                for (int i = 0; i < 4; i++) {
                    int newRow = r + dirX[i];
                    int newCol = c + dirY[i];
                    if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols || mat[newRow][newCol] >= 0) {
                        continue;
                    }
                    mat[newRow][newCol] = length;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        return mat;
    }
}
