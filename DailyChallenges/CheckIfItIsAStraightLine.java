package DailyChallenges;

/* 1232. Check If It Is a Straight Line

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.

*/

public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] a = coordinates[0];
        int[] b = coordinates[1];
        int x1 = a[0];
        int x2 = b[0];
        int y1 = a[1];
        int y2 = b[1];

        for (int i = 2; i < coordinates.length; i++) {
            int[] curr = coordinates[i];
            int x3 = curr[0];
            int y3 = curr[1];
            if((y2 - y1)*(x3 - x1) != (x2 - x1)*(y3 - y1)) return false; 
        }
        return true;
    }
}
