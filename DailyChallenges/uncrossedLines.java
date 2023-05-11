package DailyChallenges;

/* 1035. Uncrossed Lines

You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.

We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:

nums1[i] == nums2[j], and
the line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).

Return the maximum number of connecting lines we can draw in this way.

 

Example 1:


Input: nums1 = [1,4,2], nums2 = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.
Example 2:

Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
Output: 3
Example 3:

Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
Output: 2
 

Constraints:

1 <= nums1.length, nums2.length <= 500
1 <= nums1[i], nums2[j] <= 2000

*/

public class uncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        HashMap<String, Integer> map = new HashMap<>();
        return rec(nums1, 0, nums2, 0, map);
    }

    int rec(int[] nums1, int i, int[] nums2, int j, HashMap<String, Integer> map){
        if(i == nums1.length || j == nums2.length) return 0;
        String key = i + " " + j;
        if(map.containsKey(key)) return map.get(key);
        int count=0;
        if(nums1[i]==nums2[j]){
            count = 1+rec(nums1, i+1, nums2, j+1, map);
        } else{
            count+= Math.max(rec(nums1, i+1, nums2, j, map), rec(nums1, i, nums2, j+1, map));
        }
        map.put(key, count);
        return count;
    }
}
