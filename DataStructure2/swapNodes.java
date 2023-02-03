package DataStructure2;

/* 24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100

*/

public class swapNodes {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        ListNode curr = temp.next;
        while(curr!=null){
            ListNode next = curr.next;
            if(next==null){
                break;
            }
            curr.next=next.next;
            next.next=prev.next;
            prev.next=next;
            prev=curr;
            curr=curr.next;
        }
        return temp.next;
    }
}
