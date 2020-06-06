package p1466;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private boolean[] completed;
    private final List<List<Integer>> graph = new ArrayList<>();
    private final List<List<Integer>> inGraph = new ArrayList<>();
    private final Queue<Integer> q = new LinkedList<>();
    private int answer = 0;

    public int minReorder(int n, int[][] connections) {
        completed = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            inGraph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            inGraph.get(connection[1]).add(connection[0]);
        }

        dfs(0);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : graph.get(x)) {
                if (!completed[y]) {
                    answer++;
                    dfs(y);
                }
            }
        }

        return answer;
    }

    private void dfs(int i) {
        q.add(i);
        completed[i] = true;
        for (int x : inGraph.get(i)) {
            if (!completed[x]) {
                dfs(x);
            }
        }
    }
}