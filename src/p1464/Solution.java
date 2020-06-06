package p1464;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    private final Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public int maxProduct(int[] nums) {
        for (int num : nums) {
            pq.add(num);
        }
        return (pq.poll() - 1) * (pq.poll() - 1);
    }
}