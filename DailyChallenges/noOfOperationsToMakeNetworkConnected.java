package DailyChallenges;

/* 1319. Number of Operations to Make Network Connected

There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

 

Example 1:


Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:


Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
 

Constraints:

1 <= n <= 105
1 <= connections.length <= min(n * (n - 1) / 2, 105)
connections[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated connections.
No two computers are connected by more than one cable.

*/

public class noOfOperationsToMakeNetworkConnected {
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) return -1;
    
            int[] parents = new int[n];
            int[] ranks = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
    
            int components = n;
            for (int[] connection : connections) {
                components -= uniteAndCount(parents, ranks, connection[0], connection[1]);
            }
    
            return components - 1;
        }
    
        private int uniteAndCount(int[] parents, int[] ranks, int node1, int node2) {
            int parent1 = findParent(parents, node1);
            int parent2 = findParent(parents, node2);
    
            if (parent1 == parent2) return 0;
    
            if (ranks[parent1] > ranks[parent2]) {
                parents[parent2] = parent1;
                ranks[parent1] += ranks[parent2];
            } else {
                parents[parent1] = parent2;
                ranks[parent2] += ranks[parent1];
            }
    
            return 1;
        }
    
        private int findParent(int[] parents, int node) {
            while (node != parents[node]) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
    
            return node;
        }
    }
}
