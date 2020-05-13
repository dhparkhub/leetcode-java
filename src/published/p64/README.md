# [Leetcode] 64. Minimum Path Sum

오른쪽 아래 끝까지 가는 경로 중에서, 경로의 합 중 최소값을 가지는 경로의 합을 반환한다.

## Solution

`(r, c)`까지 가는 경로는 `(r-1, c)`에서 오거나 `(r, c-1)`에서 오는 경로 중 최소값을 선택할 수 있다. 재귀 함수를 통해서 이 문제를 풀 수 있으며, 중복 계산을 방지하기 위해 한 번 방문한 곳은 값을 저장하고 바로 반환해준다.

```java
class Solution {
    private int[][] grid;
    private int[][] cache;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        cache = new int[maxRow][maxCol];
        return getMinPathSum(maxRow - 1, maxCol - 1);
    }

    private int getMinPathSum(int r, int c) {
        if (r == 0 && c == 0) return grid[r][c];
        if (cache[r][c] != 0) return cache[r][c];
        if (r == 0) return cache[r][c] = grid[r][c] + getMinPathSum(r, c - 1);
        if (c == 0) return cache[r][c] = grid[r][c] + getMinPathSum(r - 1, c);
        return cache[r][c] = grid[r][c] + Math.min(getMinPathSum(r - 1, c), getMinPathSum(r, c - 1));
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(MN) | 0 ms | 42.1 MB |
