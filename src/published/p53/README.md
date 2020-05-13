# [Leetcode] 53. Maximum Subarray

배열에서 연속된 부분집합 중에서 부분집합의 합이 가장 큰 부분집합의 합을 반환한다.

## Solution

배열을 순차적으로 탐색하면서, 임의의 원소에 대해 해당 원소를 기존 부분집합에 포함시킬지, 아니면 그 원소를 새로운 부분집합의 시작점으로 할 지를 결정한다. 기존 부분집합의 합이 0보다 작다면 새로운 원소를 시작점으로 부분집합을 만들어 나가면 되고, 0보다 크다면 새로운 원소를 기존 부분집합에 포함시켜 나간다.

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int tempSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tempSum < 0) {
                tempSum = nums[i];
            } else {
                tempSum += nums[i];
            }
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 0 ms | 39.4 MB |
