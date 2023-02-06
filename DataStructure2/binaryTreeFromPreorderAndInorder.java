package DataStructure2;

/* 105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.

*/

public class binaryTreeFromPreorderAndInorder {
    // Pointer to track preorder list.
    public static int currentIndx = 0;

    // Helps to find the location of node in inorder list in O(1)
    HashMap<Integer, Integer> cache;

    // Function as described in pseudocode above
    public TreeNode constructTree(int[] preorder, int[] inorder, int start, int end) {

        if(currentIndx >= preorder.length) return null;

        // Creating the node from preorder
        int headNodeValue = preorder[currentIndx++];
        TreeNode head = new TreeNode(headNodeValue);

        int targetIndx = cache.get(headNodeValue);

        // Finding Left Subtree from inorder
        if(targetIndx - start > 0) {
            head.left = constructTree(preorder, inorder, start, targetIndx - 1);
        }

        // Finding Right Subtree from inorder
        if(end - targetIndx > 0) {
            head.right = constructTree(preorder, inorder, targetIndx + 1, end);
        }

        return head;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        currentIndx = 0;
        cache = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }
        return constructTree(preorder, inorder, 0, preorder.length - 1);
    }
}
