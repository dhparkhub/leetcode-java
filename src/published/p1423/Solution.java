package published.p1423;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer += cardPoints[i];
        }
        int tempSum = answer;
        for (int i = k - 2; i >= -1; i--) {
            int tempIndex1 = (i + 1) % cardPoints.length;
            int tempIndex2 = (i - k + 1 + cardPoints.length) % cardPoints.length;
            tempSum = tempSum - cardPoints[tempIndex1] + cardPoints[tempIndex2];
            answer = Math.max(answer, tempSum);
        }
        return answer;
    }
}