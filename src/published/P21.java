package published;

import java.util.PriorityQueue;

public class P21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode headNode = null;
            ListNode curNode = null;

            while (l1 != null || l2 != null) {
                ListNode tempNode = null;

                // find next node
                if (l1 == null) {
                    tempNode = l2;
                    l2 = l2.next;
                }
                else if (l2 == null) {
                    tempNode = l1;
                    l1 = l1.next;
                }
                else {
                    if (l1.val < l2.val) {
                        tempNode = l1;
                        l1 = l1.next;
                    } else {
                        tempNode = l2;
                        l2 = l2.next;
                    }
                }

                // connect node to list
                if (headNode == null) {
                    headNode = curNode = tempNode;
                } else {
                    curNode.next = tempNode;
                    curNode = tempNode;
                }
            }

            return headNode;
        }
    }

}
