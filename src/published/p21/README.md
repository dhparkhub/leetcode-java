# [Leetcode] 21. Merge Two Sorted Lists

오름차순으로 정렬된 두 링크드 리스트를 하나로 합치되, 합친 링크드 리스트도 오름차순으로 정렬되어야 한다.

## Solution

두 리스트를 동시에 탐색하면서, 둘 중 작은 노드를 취하는 방식으로 링크드 리스트를 연결해 나간다.

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headNode = null;
        ListNode curNode = null;

        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                curNode = l1 != null ? l1 : l2;
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
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(NM) | 0 ms | 38.9 MB |
