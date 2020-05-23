# [Leetcode] 743. Network Delay Time

주어진 네트워크 노드를 모두 탐색할 때 걸리는 시간을 반환한다.

## Solution

기본적으로 너비 우선 탐색(BFS)를 이용해 노드를 방문한다. 임의의 노드를 방문할 때 해당 노드를 방문하기까지 걸린 시간을 기록하고, 중복으로 노드를 방문할 때 이전보다 시간이 짧으면 새로운 시간으로 갱신해준다. 탐색이 종료된 후 방문하지 않은 노드가 있다면 `-1`을 반환하고 없다면 그 중 가장 오래된 시간(모든 노드를 방문하기까지 걸린 총 시간)을 반환한다.

```java
class Solution {
    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final List<List<Pair>> graph = new ArrayList<>();
    private int[] cache;

    public int networkDelayTime(int[][] times, int N, int K) {
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        cache = new int[N];
        Arrays.fill(cache, -1);

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];
            graph.get(u).add(new Pair(v, w));
        }

        bfs(K - 1);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (cache[i] == -1) return -1;
            answer = Math.max(answer, cache[i]);
        }
        return answer;
    }

    private void bfs(int x) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (cache[p.x] != -1 && p.y >= cache[p.x]) {
                continue;
            }
            cache[p.x] = p.y;

            for (Pair np : graph.get(p.x)) {
                q.add(new Pair(np.x, p.y + np.y));
            }
        }
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(V+E) | 19 ms | 44.7 MB |
