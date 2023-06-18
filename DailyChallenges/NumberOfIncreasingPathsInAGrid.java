package DailyChallenges;

/* 2328. Number of Increasing Paths in a Grid

You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all 4 directions.

Return the number of strictly increasing paths in the grid such that you can start from any cell and end at any cell. Since the answer may be very large, return it modulo 109 + 7.

Two paths are considered different if they do not have exactly the same sequence of visited cells.

 

Example 1:


Input: grid = [[1,1],[3,4]]
Output: 8
Explanation: The strictly increasing paths are:
- Paths with length 1: [1], [1], [3], [4].
- Paths with length 2: [1 -> 3], [1 -> 4], [3 -> 4].
- Paths with length 3: [1 -> 3 -> 4].
The total number of paths is 4 + 3 + 1 = 8.
Example 2:

Input: grid = [[1],[2]]
Output: 3
Explanation: The strictly increasing paths are:
- Paths with length 1: [1], [2].
- Paths with length 2: [1 -> 2].
The total number of paths is 2 + 1 = 3.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
1 <= grid[i][j] <= 105

*/

public class NumberOfIncreasingPathsInAGrid {
    int path[][];
int mod=(int)Math.pow(10,9)+7;
public int countPaths(int[][] grid) {
int n=grid.length;
int m=grid[0].length;

    int ans=0;
    path=new int[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
           
            ans=(ans%mod+ dfs(grid,i,j,m,n,-1)%mod)%mod;
            
        }
    }
    return ans;
}
public int dfs(int[][] grid,int x,int y,int m,int n,int pre){
    if(x<0 || y<0 || x>=n || y>=m)return 0;
    if(grid[x][y]<=pre)return 0;
    if(path[x][y]!=0)return path[x][y];
   
    int l1=dfs(grid,x+1,y,m,n,grid[x][y]);
    int l2=dfs(grid,x-1,y,m,n,grid[x][y]);
    int l3=dfs(grid,x,y+1,m,n,grid[x][y]);
    int l4=dfs(grid,x,y-1,m,n,grid[x][y]);
    
    return  path[x][y]=(1+l1+l2+l3+l4)%mod;
}  
}
