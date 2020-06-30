# [Leetcode] 1405. Longest Happy String

주어진 `a`, `b`, `c`를 가지고 최대한 긴 `Happy String`을 찾아 반한한다.

## Solution

기본적으로 탐욕(`Greedy`) 알고리즘을 사용한다. 알파벳의 개수를 관리하면서 그 개수가 가장 많은 것을 먼저 취한다. 단, 2번 연속 같은 알파벳이 나오면 그 다음으로 많은 알파벳을 취한다.

```java
class Solution {
    private final StringBuilder answer = new StringBuilder();
    private int[] count;
    private final PriorityQueue<Character> pq = new PriorityQueue((x, y) -> count[(char)y - 'a'] - count[(char)x - 'a']);

    public String longestDiverseString(int a, int b, int c) {
        count = new int[]{a, b, c};

        if (a > 0) pq.add('a');
        if (b > 0) pq.add('b');
        if (c > 0) pq.add('c');

        while (!pq.isEmpty()) {
            char temp = pq.poll();
            int size = answer.length();
            if (size >= 2 && answer.charAt(size - 1) == temp && answer.charAt(size - 2) == temp) {
                if (pq.isEmpty()) break;
                char temp2 = pq.poll();
                answer.append(temp2);
                if (--count[temp2 - 'a'] != 0) {
                    pq.add(temp2);
                }
                pq.add(temp);
                continue;
            }

            answer.append(temp);
            if (--count[temp - 'a'] != 0) {
                pq.add(temp);
            }
        }

        return answer.toString();
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| - | 2 ms | 36.3 MB |
