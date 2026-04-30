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
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        int position = size - n;
        if (position == 0) {
            return head.next;
        }

        curr = head;
        int i = 0;
        while (i < size) {
            if (i == position - 1) {
                curr.next = curr.next.next;
                break;
            }

            i++;
            curr = curr.next;
        }

        return head;

    }
}
