# [Leetcode] 206. Reverse Linked List

주어진 링크드 리스트의 방향을 역순으로 하여 반환한다.

## Solution

주어진 링크드 리스트의 노드를 순차적으로 탐색하되, 탐색 중인 노드의 이전 노드와 다음 노드를 갱신시켜 주면서 역순으로 연결해나간다. 

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prevNode = null;
        ListNode curNode = head;
        ListNode nextNode = head.next;
        while (curNode != null) {
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
            if (curNode != null) {
                nextNode = curNode.next;
            }
        }
        return prevNode;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 0 ms | 39 MB |
