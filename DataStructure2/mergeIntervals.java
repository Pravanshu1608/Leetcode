package DataStructure2;

/* 56. Merge Intervals
Medium
17.8K
616
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

*/

public class mergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int[]> output = new ArrayList();
        int[] currlist = intervals[0];
        output.add(currlist);

        for(int[] interval : intervals){
            int begin = currlist[0];
            int end = currlist[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if(end>=next_begin){
                currlist[1] = Math.max(end, next_end);
            } else{
                currlist=interval;
                output.add(currlist);
            }
        }
        return output.toArray(new int[output.size()][]);
        
    }
}
