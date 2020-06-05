package p1409;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[j] == queries[i]) {
                    answer[i] = j;
                    for (int k = j; k > 0; k--) {
                        int temp = arr[k];
                        arr[k] = arr[k - 1];
                        arr[k - 1] = temp;
                    }
                    break;
                }
            }
        }

        return answer;
    }
}