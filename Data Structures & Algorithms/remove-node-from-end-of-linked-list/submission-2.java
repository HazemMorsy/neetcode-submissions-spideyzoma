/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = new ListNode(0, head);
        ListNode ans = curr;
        ListNode next = head;
        int diff = n;
        //[1,2,3,4]
        // curr : before arr
        // next : at 3
        while (diff > 0) {
            next = next.next;
            diff--;
        }

        //[1,2,3,4]
        // curr : at 2
        // next : after 4 at the end
        while (next != null) {
            curr = curr.next;
            next = next.next;
        }
        
        ListNode toRemove = curr.next;
        curr.next = toRemove.next;
        toRemove.next = null;

        return ans.next;
    }
}
