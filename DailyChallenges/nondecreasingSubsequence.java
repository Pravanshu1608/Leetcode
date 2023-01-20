package DailyChallenges;

/* 491. Non-decreasing Subsequences

Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

 

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]
 

Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100

*/

public class nondecreasingSubsequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        backtrack(nums, 0, new ArrayList<>(), set);

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    void backtrack(int[] nums, int idx, List<Integer> cur, Set<List<Integer>> set){
        if(cur.size()>=2){
            set.add(new ArrayList<>(cur));
        }

        if(idx==nums.length) return;

        for(int i=idx; i<nums.length; i++){
            if(cur.size()==0 || cur.get(cur.size() - 1) <= nums[i]){
                cur.add(nums[i]);
                backtrack(nums, i+1, cur, set);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
