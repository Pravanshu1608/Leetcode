package DailyChallenges;

/* 934. Shortest Bridge

You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.

 

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 

Constraints:

n == grid.length == grid[i].length
2 <= n <= 100
grid[i][j] is either 0 or 1.
There are exactly two islands in grid.

*/

public class ShortestBridge {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int shortestBridge(int[][] grid) {
        
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] visited = new int[rows][columns];
        int islandCount = 0;
        Queue<Pair> queue = new LinkedList<>();


        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    islandCount++;
                    DFS(i, j, grid, visited, islandCount);
                }
                if(visited[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        int count = 0;

        outer: while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair current = queue.poll();
                for(int j = 0; j < 4; j++) {
                    int row = current.row + dx[j];
                    int column = current.column + dy[j];
                    if(!isSafe(row, column, grid) || visited[row][column] == 2) {
                        continue;
                    }
                    if(visited[row][column] == 1) {
                        break outer;
                    }
                    queue.add(new Pair(row, column));
                    visited[row][column] = 2;
                }
            }
            count++;
        }
        return count;
    }

    public void DFS(int i, int j, int[][] grid, int[][] visited, int islandCount) {

        if(!isSafe(i, j, grid) || visited[i][j] == islandCount || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = islandCount;
        for(int x = 0; x < 4; x++) {
            int row = i + dx[x];
            int column = j + dy[x];
            DFS(row, column, grid, visited, islandCount);
        }
    }

    public boolean isSafe(int i, int j, int[][] grid) {

        int rows = grid.length;
        int columns = grid[0].length;
        if(i < 0 || i >= rows || j < 0 || j >= columns) {
            return false;
        }
        return true;
    }

    class Pair {

        int row;
        int column;
        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
