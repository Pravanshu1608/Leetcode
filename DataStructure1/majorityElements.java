package DataStructure1;

/* 229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 */

public class majorityElements {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list= new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();

        int n =nums.length;
        int x=n/3;

        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else{
                int count=map.get(nums[i]);
                map.put(nums[i], count+1);
            }
        }

        for(Map.Entry m:map.entrySet()){
            Integer temp= (Integer) m.getValue();
            if(temp>x)
                list.add((Integer)m.getKey());
        }
        return list;
        
    }
    
}
