package published.p21;

class ListNode {
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
            if (l1 == null || l2 == null) {
                if (headNode == null) {
                    headNode = curNode = l1 != null ? l1 : l2;
                } else {
                    curNode.next = l1 != null ? l1 : l2;
                }
                break;
            }

            ListNode tempNode = null;
            if (l1.val < l2.val) {
                tempNode = l1;
                l1 = l1.next;
            } else {
                tempNode = l2;
                l2 = l2.next;
            }

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
