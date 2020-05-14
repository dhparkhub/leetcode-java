# [Leetcode] 1394. Find Lucky Integer in an Array

배열의 원소 중에서 원소의 값과 원소의 개수가 같은 원소 중 가장 큰 원소를 반환한다.

## Solution

배열을 순차적으로 탐색하면서 해당 원소가 나온 횟수를 카운트한다. 배열 원소의 최대값이 `500`이기 때문에 500부터 1까지 원소의 값과 나온 횟수가 같은 원소를 반환한다. 없다면 `-1`을 반환한다.

```java
class Solution {
    private final int[] visited = new int[501];

    public int findLucky(int[] arr) {
        for (int i : arr) {
            visited[i]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (i == visited[i]) {
                return i;
            }
        }
        return -1;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 1 ms | 39.2 MB |
