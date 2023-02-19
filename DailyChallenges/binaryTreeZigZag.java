package DailyChallenges;

/* 103. Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

*/

public class binaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>list=new ArrayList<>();
        if(root==null){
           return list;
       }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty()){
            int len=queue.size();
            List<Integer>levellist=new ArrayList<>();
            for(int i=0;i<len;i++){
            TreeNode temp=queue.poll();
            if(temp.left!=null)
                queue.add(temp.left);
            
            if(temp.right!=null)
                queue.add(temp.right);
            
            if(level%2==0)
                levellist.add(temp.val);
            else
                levellist.add(0,temp.val);
        }
        level++;
        list.add(levellist);
        }
        return list;
    }
}
