package p1394;

class Solution {
    private final int[] visited = new int[501];

    public int findLucky(int[] arr) {
        for (int i : arr) {
            visited[i]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (i == visited[i]) {
                return i;
            }
        }
        return -1;
    }
}
