package published.p1403;

import java.util.*;

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