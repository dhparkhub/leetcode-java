# [Leetcode] 1395. Count Number of Teams

임의로 뽑은 군인 3명의 평점이 오름차순이거나 내림차순인 모든 경우의 수를 반환한다.

## Solution

3중 반복문을 통해 모든 경우의 수를 구하는 완전 탐색으로 문제를 푼다.

```java
class Solution {
    public int numTeams(int[] rating) {
        int teamCount = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        teamCount++;
                        continue;
                    }
                    if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        teamCount++;
                    }
                }
            }
        }
        return teamCount;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N^3) | 21 ms | 36.8 MB |
