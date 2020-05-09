# [Leetcode] 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

배열의 연속된 부분 배열 중에서 최대값과 최소값의 차이가 `limit`보다 작은 부분 배열의 길이 중 최대값을 반환한다.

## Solution

기본적으로는 이중 반복문을 사용하여 모든 `subarray`를 다 탐색한다. 임의의 시점에서 최대값이 최소값의 차이가 `limit`보다 커지면 `subarray`의 시작점을 한 칸 뒤로 해서 다시 탐색한다. `subarray`의 시작점이 이전 경우와 같으면 굳이 반복할 필요가 없으므로 넘어간다.

```java
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int maxNum = nums[i];
            int minNum = nums[i];
            for (int j = i; j < nums.length; j++) {
                maxNum = Math.max(maxNum, nums[j]);
                minNum = Math.min(minNum, nums[j]);
                if (maxNum - minNum <= limit) {
                    maxLength = Math.max(maxLength, j - i + 1);
                    continue;
                }
                break;
            }
        }
        return maxLength;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N^2) | 18 ms | 48.3 MB |
