//leetcode 653
//Time complexity O(2n) -> O(n)
//space complexity O(n)

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
    public void addNodes(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        addNodes(root.left, list);
        list.add(root.val);
        addNodes(root.right, list);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        addNodes(root, list);
        int i = 0;
        int j = list.size() - 1;

        while(i < j){
            int sum = list.get(i) + list.get(j);
            if(sum == k){
                return true;
            }
            if(sum > k){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}