# [Leetcode] 1437. Check If All 1's Are at Least Length K Places Away

배열에서 1과 1 사이의 간격의 최소값이 `k`인지 반환한다.

## Solution 1

1의 위치를 모두 구해 `List`에 담는다. 1 사이의 간격을 모두 구해 `k`보다 같거나 큰지 판별한다.

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tempList.add(i);
            }
        }

        int tempLength = Integer.MAX_VALUE;
        for (int i = 0; i < tempList.size() - 1; i++) {
            tempLength = Math.min(tempLength, tempList.get(i + 1) - tempList.get(i) - 1);
            if (tempLength < k) return false;
        }

        return true;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 4 ms | 50 MB |


## Solution 2

1의 위치를 모두 구해 `List`에 담는 과정을 생략하고 한 번만 탐색하면서 1의 이전 위치와 현재 위치를 비교하여 그 간격이 `k`보다 같거나 큰지 판별한다.

```java
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int tempIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (tempIndex == -1) {
                    tempIndex = i;
                    continue;
                }
                minLength = Math.min(minLength, i - tempIndex - 1);
                if (minLength < k) return false;
                tempIndex = i;
            }
        }
        return true;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 1 ms | 49.5 MB |
