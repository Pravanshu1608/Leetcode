package DataStructure2;

/* 143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000

*/

public class reorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow=head, fast=head, prev=head;
        while(fast!=null && fast.next !=null){
            prev = slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode l1 = head;
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    static ListNode reverse(ListNode l2){
        if(l2==null) return null;
        ListNode prev = null, curr=l2, nex=l2.next;
        while(curr!=null){
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return prev;
    }

    static void merge(ListNode l1, ListNode l2){
        while(l2!=null){
            ListNode next = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = next;
        }
    }
}
