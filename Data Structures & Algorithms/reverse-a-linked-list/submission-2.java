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
    public ListNode reverseList(ListNode head) {
        // 0 -> 1 -> 2 -> null
        // to result : null <- 0 <- 1 <- 2
        if (head == null || head.next == null) {
            return head;
        }

        // by default it will return the head of the current list but we need to keep track of the value of the last head
        ListNode lastHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return lastHead;
        
    }
}
