package DailyChallenges;

/* 149. Max points on a line
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

 

Example 1:


Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:


Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
 

Constraints:

1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.

 */

public class maxPoints {
    public int maxPoints(int[][] points) {
        if(points.length<=2) return points.length;

        int ans=2;
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                int temp=2;
                for(int k=0; k<points.length; k++){
                    int x=(points[j][1] - points[i][1])*(points[k][0] - points[i][0]);
                    int y=(points[k][1] - points[i][1])*(points[j][0] - points[i][0]);
                    if(k!=i && k!=j){
                        if(x==y){
                            temp++;
                        }
                    }
                }
                if(temp>ans){
                    ans=temp;
                }
            }
        }
        return ans; 
        
    }
}
