package DataStructure2;

/* 199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

*/

public class binaryTreeRightSideView {
    void rightView(TreeNode root, List<Integer> ans, int level) {
        if (root == null) return;
        if (ans.size() == (level - 1)) // 0 1
            ans.add(root.val);
        if (root.right != null)
            rightView(root.right, ans, level + 1);
        if (root.left != null) 
            rightView(root.left, ans, level + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        rightView (root, ans, 1);

        return ans;
    }
}
