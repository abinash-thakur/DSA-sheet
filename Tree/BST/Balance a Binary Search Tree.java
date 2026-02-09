/*
leetcode - 1382
timecomplexity - O(n)
*/


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
    private void findList(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        findList(root.left, list);
        list.add(root.val);
        findList(root.right, list);
    }
    private TreeNode makeTree(List<Integer> list, int l, int r){
        if(l > r){
            return null;
        }

        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = makeTree(list, l, mid - 1);
        root.right = makeTree(list, mid + 1, r);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findList(root, list);
        int n = list.size();
        return makeTree(list, 0, n - 1);
    }
}