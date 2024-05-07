//2816. Double a Number Represented as a Linked List(medium)
// You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

// Return the head of the linked list after doubling it.

// Example 1:

// Input: head = [1,8,9]
// Output: [3,7,8]
// Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.

// Example 2:

// Input: head = [9,9,9]
// Output: [1,9,9,8]
// Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
 

// Constraints:

// The number of nodes in the list is in the range [1, 104]
// 0 <= Node.val <= 9
// The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.

//ANSWER
//we can solve this problem using two ways.
//way - 1
//By using the stack we can push all the nodes in to the stack and after that pop one by one all the nodes from the stack and perform the moulo and devide by 10 operation and puth the carry in a variable.

// by uisng the stack
class Solution{
    public ListNode doubleIt(ListNode head) {
        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        int carry = 0;

        while(!stack.isEmpty()){
            temp = stack.pop();
            int val = temp.val * 2 + carry;
            temp.val = val % 10;
            carry = val / 10;
        }

        while(carry != 0){
            ListNode newNode = new ListNode();
            newNode.val = carry % 10;
            carry = carry / 10;
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}

//The time complexcity is O(2N)+O(D)
//we have to Iterate the 2 loops one for push all the node in to the stack it take O(n) and enethor one is used for take all the element one by one from the stack it's all so take O(n) so it takes O(2n)
//we used enethor loops for createing node for length of the number present in the carry, so let's take the length of the element in carry id d, so the loop is iterate O(d) times 
//So overall time complexcity is O(2n)+O(d)
//we have a space complexcity all beacuse we used the stack so it's take O(n).

//by using the recurssion 
class Solution {
    public ListNode doubleIt(ListNode head) {
        int carry = twiceValue(head);
        while(carry != 0){
            ListNode newNode = new ListNode();
            newNode.val = carry % 10;
            newNode.next = head;
            head = newNode;
            carry = carry / 10;
        }
        return head;
    }
    public int twiceValue(ListNode head){
        if(head == null) return 0;

        int doubleValue = head.val * 2 + twiceValue(head.next);
        head.val = doubleValue % 10;
        return doubleValue / 10;
    }
}

//The total time complexcity is O(n)+O(d)
//beacause we used the single recurssion function that will iterate upto O(n) times and we have to create a new node for total length of carry number, so let's the length of the carry is d then it take O(d) times.

//space complexcity O(n)
//beacuse in this recurssion is a tail recurssive recurssion, so it maintain the call stack in a backgroun for function call it will take O(n)