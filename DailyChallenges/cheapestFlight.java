package DailyChallenges;

/* 787. Cheapest Flights Within K Stops

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

Example 1:


Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst

*/

public class cheapestFlight {
    int N;
    int[][] edges;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        this.N = n;
        this.edges = flights;
           
        return bellman_ford(src, dst, k);
    }
    
    public int bellman_ford(int src, int dst, int k){
        
        int[] dist = new int[this.N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        for(int i=0; i<=k; i++){
            int[] tmp = Arrays.copyOf(dist, this.N);
            for(int[] now : this.edges){
                if(dist[now[0]] != Integer.MAX_VALUE && dist[now[0]] + now[2] < tmp[now[1]]){
                    tmp[now[1]] = dist[now[0]] + now[2]; 
                }
            }
            
            dist = tmp;
        }
        
        
        return (dist[dst] == Integer.MAX_VALUE)? -1 : dist[dst];
    }
}
