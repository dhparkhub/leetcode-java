# [Leetcode] 2. Add Two Numbers

2개의 정수가 링크드 리스트로 주어지고, 2개의 정수를 더해 링크드 리스트로 반환하면 된다.

## Solution

링크드 리스트의 `Head` 노드가 가리키는 자리수가 1의 자리수이기 때문에 두 리스트 모두 `Head` 노드부터 순차적으로 탐색하면서 더해간다. 이때 자리올림수가 있다면 다음 덧셈 때 같이 더해주고, 임의의 노드가 `Null`일 경우에는 `0`으로 치환해서 더해준다. 마지막 올림자리수를 놓칠 수 있기 때문에 반복문이 종료되고 마지막으로 올림자리수를 한 번 더 탐색해서 연결해준다.

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = null;
        ListNode curNode = null;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            int tempNum = (l1Val + l2Val + carry) % 10;
            carry = (l1Val + l2Val + carry) / 10;

            ListNode tempNode = new ListNode(tempNum);
            if (headNode == null) {
                headNode = curNode = tempNode;
            } else {
                curNode.next = tempNode;
                curNode = tempNode;
            }

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        if (carry == 1) {
            curNode.next = new ListNode(1);
        }

        return headNode;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 2 ms | 39.8 MB |
