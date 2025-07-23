//leetcode 173
//we are using the stack to solve the problem
//time complexity O(h) because we traversing only the height of the tree
//space complexity O(n) because we used the stack

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
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        addNodeToStack(root);
    }
    
    public int next() {
        TreeNode top = stack.pop();
        int next = top.val;
        if(top.right != null){
            addNodeToStack(top.right);
        }
        return next;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void addNodeToStack(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */