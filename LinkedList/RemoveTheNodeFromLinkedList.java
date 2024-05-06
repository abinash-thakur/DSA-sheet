//2487. Remove Nodes From Linked List
// You are given the head of a linked list.

// Remove every node which has a node with a greater value anywhere to the right side of it.

// Return the head of the modified linked list.

// Example 1:

// Input: head = [5,2,13,3,8]
// Output: [13,8]
// Explanation: The nodes that should be removed are 5, 2 and 3.
// - Node 13 is to the right of node 5.
// - Node 13 is to the right of node 2.
// - Node 8 is to the right of node 3.
// Example 2:

// Input: head = [1,1,1,1]
// Output: [1,1,1,1]
// Explanation: Every node has value 1, so no nodes are removed.
 

// Constraints:

// The number of the nodes in the given list is in the range [1, 105].
// 1 <= Node.val <= 105

//solution
//In this actually we have to used the motonic stack to find the next largest element, we follow this approach.
//step-1
//first we have to find the next largest element and put it in to the stack.
//after that we traverse the stack and assign the linked list in reverse order.

class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack <ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while(temp != null){
            while(!stack.isEmpty() && temp.val > stack.peek().val){
                stack.pop();
            }
            stack.push(temp);
            temp = temp.next;
        }

        ListNode newNode = null;
        while(!stack.isEmpty()){
            temp = stack.pop();
            temp.next = newNode;
            newNode = temp;
        }
        return newNode;
    }
}