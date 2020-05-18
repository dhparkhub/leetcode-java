# [Leetcode] 200. Number of Islands

주어진 좌표에서 섬의 개수를 반환한다.

## Solution

`DFS(Depth-First Search)`를 사용하여 섬의 개수를 구한 뒤 반환한다.

```java
class Solution {
    private final int[] mr = {0, 1, 0, -1};
    private final int[] mc = {1, 0, -1, 0};
    private char[][] grid;
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + mr[i];
            int nc = c + mc[i];
            if (valid(nr, nc) && !visited[nr][nc] && grid[nr][nc] == '1') {
                dfs(nr, nc);
            }
        }
    }

    private boolean valid(int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(RC) | 2 ms | 42.1 MB |
