package published.p1405;

import java.util.PriorityQueue;

class Solution {
    private final StringBuilder answer = new StringBuilder();
    private int[] count;
    private final PriorityQueue<Character> pq = new PriorityQueue((x, y) -> count[(char)y - 'a'] - count[(char)x - 'a']);

    public String longestDiverseString(int a, int b, int c) {
        count = new int[]{a, b, c};

        if (a > 0) pq.add('a');
        if (b > 0) pq.add('b');
        if (c > 0) pq.add('c');

        while (!pq.isEmpty()) {
            char temp = pq.poll();
            int size = answer.length();
            if (size >= 2 && answer.charAt(size - 1) == temp && answer.charAt(size - 2) == temp) {
                if (pq.isEmpty()) break;
                char temp2 = pq.poll();
                answer.append(temp2);
                if (--count[temp2 - 'a'] != 0) {
                    pq.add(temp2);
                }
                pq.add(temp);
                continue;
            }

            answer.append(temp);
            if (--count[temp - 'a'] != 0) {
                pq.add(temp);
            }
        }

        return answer.toString();
    }
}