//leetcode 99
//Recover Binary Search Tree
//Time complexity O(n) only do the inorder(left, root, right) traversal.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void findNode(TreeNode root, TreeNode swapped[], TreeNode prev[]){
        if(root == null){
            return;
        }
        findNode(root.left, swapped, prev);
        if(prev[0] != null && prev[0].val > root.val){
            if(swapped[0] == null){
                swapped[0] = prev[0];
                swapped[1] = root;
            }
            else{
                swapped[1] = root;
                return;
            }
        }
        prev[0] = root;
        findNode(root.right, swapped, prev);
    }
    public void recoverTree(TreeNode root) {
        TreeNode swapped[] = new TreeNode[2];
        TreeNode prev[] = new TreeNode[1];
        findNode(root, swapped, prev);
        
        int temp = swapped[0].val;
        swapped[0].val = swapped[1].val;
        swapped[1].val = temp;
    }
}