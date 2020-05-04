package published.p1394;

import java.util.Arrays;

class Solution {
    public int findLucky(int[] arr) {
        init();
        for (int i = 0; i < arr.length; i++) {
            visited[arr[i]]++;
        }
        for (int i = 1; i <= 500; i++) {
            if (i == visited[i]) {
                answer = i;
            }
        }
        return answer;
    }

    public void init() {
        answer = -1;
        visited = new int[501];
        Arrays.fill(visited, 0);
    }

    private int answer;
    private int[] visited;
}
