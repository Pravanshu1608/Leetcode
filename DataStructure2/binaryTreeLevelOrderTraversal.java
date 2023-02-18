package DataStructure2;

/* 102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000

*/

public class binaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> mainlist = new LinkedList<List<Integer>>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null){
            return mainlist;
        }
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> l=new LinkedList<Integer>();
            for(int i=0;i<n;i++){
                TreeNode cur=q.poll();
                l.add(cur.val);
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            mainlist.add(l);
        }
        return mainlist;        
    }
}
