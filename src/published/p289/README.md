# [Leetcode] 289. Game of Life

문제에 주어진 조건대로 게임을 진행하여 보드의 상태를 수정한다.

## Solution

보드 한 칸을 좌표로 생각하여 순차적으로 모든 좌표를 탐색한다. 임의의 좌표에 대해 셀의 상태와 살아있는 이웃의 개수를 이용하여 해당 셀의 다음 상태를 `Map`에 기록한다. 모든 좌표를 다 탐색한 뒤 `Map`에 기록된 상태 변화를 사용하여 보드의 상태를 변화시킨다.

```java
class Solution {
    private class Point {
        private final int r;
        private final int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private final int[] mr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    private final int[] mc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    private final Map<Point, Integer> changeMap = new HashMap<>();
    private int[][] board;
    private int maxRow;
    private int maxCol;

    public void gameOfLife(int[][] board) {
        this.board = board;
        maxRow = board.length - 1;
        maxCol = board[0].length - 1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int countNeighborhood = getNeighborhood(i, j);
                if (board[i][j] == 0 && countNeighborhood == 3) {
                    changeMap.put(new Point(i, j), 1);
                    continue;
                }
                if (board[i][j] == 1 && countNeighborhood >= 2 && countNeighborhood <= 3) {
                    changeMap.put(new Point(i, j), 1);
                    continue;
                }
                if (board[i][j] == 1) {
                    changeMap.put(new Point(i, j), 0);
                }
            }
        }

        changeMap.keySet().forEach(key -> board[key.r][key.c] = changeMap.get(key));
    }

    private int getNeighborhood(int r, int c) {
        int countNeighborhood = 0;
        for (int i = 0; i < 8; i++) {
            int nr = r + mr[i];
            int nc = c + mc[i];
            if (isValidPoint(nr, nc) && board[nr][nc] == 1) {
                countNeighborhood++;
            }
        }
        return countNeighborhood;
    }

    private boolean isValidPoint(int r, int c) {
        return r >= 0 && r <= maxRow && c >= 0 && c <= maxCol;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(MN) | 1 ms | 38 MB |
