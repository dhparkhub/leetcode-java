# [Leetcode] 1450. Number of Students Doing Homework at a Given Time

주어진 시간에 공부한 학생의 수를 반환한다.

## Solution

시작 시간(`startTime[i]`)과 종료 시간(`endTime[i]`)의 범위 안에 `queryTime`이 포함되는지 확인 후 카운트하면 된다.

```java
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (qu)
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }
        return count;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 0 ms | 37.6 MB |
