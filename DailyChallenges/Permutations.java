package DailyChallenges;

import java.util.ArrayList;
import java.util.List;

/* 46. Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

*/

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        solve(0, nums, list);
        return list;
    }
    public void solve(int index, int[] nums, List<List<Integer>> list){
        if(index==nums.length){
            List<Integer> ans = new ArrayList();
            for(int i=0; i<nums.length; i++){
                ans.add(nums[i]);
            }
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int i=index; i<nums.length; i++){
            swap(nums, i, index);
            solve(index+1, nums, list);
            swap(nums, i, index);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
