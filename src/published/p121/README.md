# [Leetcode] 121. Best Time to Buy and Sell Stock

주식 가격 변동이 배열로 주어지고 가장 높은 이윤을 반환한다.

## Solution 1

2중 반복문을 통해 `i` 인덱스에서 구매하고 `i+1`부터 모든 경우의 수를 판매해봄으로써 완전 탐색으로 문제를 해결한다.

```java
class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer = Math.max(answer, prices[j] - prices[i]);
            }
        }
        return answer;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N^2) | 258 ms | 39.7 MB |

## Solution 2

배열을 순차적으로 한 번만 탐색하면서 가장 싸게 살 수 있는 주식의 가격을 계속 갱신해주고, 매번 판매함으로써 얻는 수익 중 가장 높은 이익을 갱신해서 반환한다.

```java
class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            answer = Math.max(answer, prices[i] - buyPrice);
        }
        return answer;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 1 ms | 39.4 MB |
