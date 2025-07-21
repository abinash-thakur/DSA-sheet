//using bruteforce
//time complexcity O(2n)
//one O(n) for traversing the whole tree
//enethor O(n) to retrive the kth element from the priorityQueue.
//space complexcity O(n)

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
    public void addNodes(TreeNode root, PriorityQueue<Integer> pq){
        if(root == null){
            return;
        }
        addNodes(root.left, pq);
        pq.offer(root.val);
        addNodes(root.right, pq);
    }
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        addNodes(root, pq);
        int res = 0;
        for(int i = 1; i <= k; i++){
            if(i == k){
                res = pq.peek();
                break;
            }
            pq.poll();
        }
        return res;
    }
}

//Optimal approach
//find the kth smallest element in bst 
//time complexcity O(n)
//I am traversing completeree once

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
    public void findKthSmallest(TreeNode root, int k, int res[]){
        if(root == null){
            return;
        }
        findKthSmallest(root.left, k, res);
        if(res[0] == 0){
            return;
        }
        res[0]--;
        if(res[0] == 0){
            res[1] = root.val;
            return;
        }
        findKthSmallest(root.right, k, res);
    }
    public int kthSmallest(TreeNode root, int k) {
        int res[] = new int[2];
        res[0] = k;
        findKthSmallest(root, k, res);
        return res[1];
    }
}