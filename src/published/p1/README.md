# [Leetcode] 1. Two Sum

1차원 배열에서 서로 다른 두 수의 합이 `target`이 되는 두 수를 찾아 반환하는 문제이다. 

## Solution 1

2중으로 반복문을 돌면서 두 수의 합이 `target`이 되는 지점을 찾는다.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N^2) | 57 ms | 39.8 MB |


## Solution 2

배열을 탐색하되 한 번 탐색한 숫자는 `HashMap`에 넣어 저장해둔다. 임의의 숫자를 탐색할 때 `target - nums[i]`가 `HashMap`에 저장되어 있다면 두 수를 반환한다.

```java
class Solution {
    private final Map<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 1 ms | 39.2 MB |
