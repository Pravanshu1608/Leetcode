package DailyChallenges;

/* 1162. As Far from Land as Possible

Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

 

Example 1:


Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
Example 2:


Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1

*/

public class asFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        Queue<int[]>q = new LinkedList<>();
        int dx[]={-1,1,0,0};
        int dy[]={0,0,1,-1};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    q.add(new int[]{i,j});

            }
        }
        int st=0;
        while(!q.isEmpty())
        {
            
            int sz=q.size();
            for(int i=0;i<sz;i++)
            {
                int temp[]=q.poll();
                int r = temp[0],c = temp[1];
                for(int k=0;k<4;k++)
                {
                    int nr = r+dx[k],nc = c+dy[k];
                    if(nr>=0 && nc>=0 && nr<m && nc<n&& grid[nr][nc]==0)
                    {
                        grid[nr][nc]=1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            st++;
        }
        if(st== 1)
            return -1;
        return st-1;
    }
}
