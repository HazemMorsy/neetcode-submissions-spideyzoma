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
    public void reorderList(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        ListNode tempHead0 = head;
        ListNode tempHead1 = head;
        ListNode tempHead2 = head.next;
        while(tempHead0 != null) {
            map.put(index, tempHead0.val);
            tempHead0 = tempHead0.next;
            index++;
        }

        int index1 = 0;
        int index2 = index-1;
        while(tempHead1 != null) {
            tempHead1.val = map.get(index1);
            index1+=1;
            if (tempHead1.next == null) {
                break;
            }
            tempHead1 = tempHead1.next.next;
        }

        while(tempHead2 != null) {
            tempHead2.val = map.get(index2);
            index2-=1;
            if (tempHead2.next == null) {
                break;
            }
            tempHead2 = tempHead2.next.next;
        }

    }
}
