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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resPointer;
        ListNode res = new ListNode(0);
        resPointer = res;
        while (list1 != null && list2 != null) {
            // advance first pointer
            if (list1.val <= list2.val) {
                resPointer.next = new ListNode(list1.val);
                resPointer = resPointer.next;
                list1 = list1.next;
            } else {
                // advance second pointer
                resPointer.next = new ListNode(list2.val);
                resPointer = resPointer.next;
                list2 = list2.next;
            }
        }

        if (list1 == null) {
            resPointer.next = list2;
        } else {
            resPointer.next = list1;
        }

        return res.next;
    }
}