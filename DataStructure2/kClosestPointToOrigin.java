package DataStructure2;

/* 973. K Closest Points to Origin

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104

*/

public class kClosestPointToOrigin {
    public class Point implements Comparable<Point> {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point other) {
            return Integer.compare(distance(other), distance(this));
        }
        public String toString() {
            return "X: " + this.x + " Y: "+ this.y;
        }
    }
    private int distance(Point p) {
        return p.x*p.x + p.y*p.y;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> q = new PriorityQueue<>();

        for (int[] i: points) {
            Point newP = new Point(i[0], i[1]);
            if(q.size() < k) q.offer(newP);
            else {
                Point lowP = q.peek();
                if (distance(lowP) > distance(newP)) {
                    q.poll();
                    q.offer(newP);
                }
            }
        }
        int[][] ans = new int[q.size()][2];
        int i = 0;
        while(!q.isEmpty()) {
            Point p = q.poll();
            ans[i] = new int[]{p.x, p.y};
            i++;
        }
        return ans;
    }
}
