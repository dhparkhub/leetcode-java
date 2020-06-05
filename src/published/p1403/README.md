# [Leetcode] 1403. Minimum Subsequence in Non-Increasing Order

배열의 원소 중 일부를 뽑았을 때, 뽑은 원소의 합이 뽑지 않은 원소의 합보다 커지는 경우의 수 중 뽑은 원소의 개수가 가장 적은 경우의 수를 리스트로 반환한다.

## Solution

탐욕(`Greedy`) 알고리즘을 사용하기 위해 주어진 배열의 원소를 순차적으로 탐색하면서 원소의 합과 각각의 원소를 우선순위 큐에 내림차순으로 정렬한다. 우선순위 큐에 저장된 데이터를 순차적으로 꺼내면서 더하다가 이 합이 전체 중 나머지 합보다 커지는 순간에 알고리즘을 종료한다.

```java
class Solution {
    private final Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    private final List<Integer> answer = new ArrayList<>();

    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
            pq.add(num);
        }

        int tempSum = 0;
        while (!pq.isEmpty()) {
            answer.add(pq.peek());
            tempSum += pq.poll();
            if (tempSum > sum - tempSum) break;
        }

        return answer;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(NlogN) | 6 ms | 39.6 MB |
