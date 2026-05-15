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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new CustomComparator());
        for (ListNode currNode : lists) {
            pq.offer(currNode);
        }

        while (!pq.isEmpty()) {
            ListNode currNode = pq.poll();
            ListNode inRes = new ListNode(currNode.val);
            res.next = inRes;
            res = res.next;
            if (currNode.next != null) {
                pq.offer(currNode.next);
            }
        }

        return temp.next;

    }

    class CustomComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode listNode1, ListNode listNode2) {
            return (listNode1.val - listNode2.val);
        }
    }
}
