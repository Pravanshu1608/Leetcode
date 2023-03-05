package DailyChallenges;

/* 1345. Jump Game IV

Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 

Constraints:

1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108


*/

public class jumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> valuesIndexesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valuesIndexesMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // int[] -> [index, jumps]
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(new int[]{0, 0});
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] rem = queue.remove();
            int i = rem[0], jumps = rem[1];

            if (i == n - 1) return jumps;

            if (i + 1 < n && !visited[i + 1]) {
                queue.add(new int[]{i + 1, jumps + 1});
                visited[i + 1] = true;
            }

            if (i - 1 >= 0 && !visited[i - 1]) {
                queue.add(new int[]{i - 1, jumps + 1});
                visited[i - 1] = true;
            }

            for (int nextIndex : valuesIndexesMap.get(arr[i])) {
                if (nextIndex != i && !visited[nextIndex]) {
                    queue.add(new int[]{nextIndex, jumps + 1});
                    visited[nextIndex] = true;
                }
            }

            valuesIndexesMap.put(arr[i], new ArrayList<>());
        }

        return -1;
    }
}
