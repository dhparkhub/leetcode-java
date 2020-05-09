package published.p1438;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int maxNum = nums[i];
            int minNum = nums[i];
            for (int j = i; j < nums.length; j++) {
                maxNum = Math.max(maxNum, nums[j]);
                minNum = Math.min(minNum, nums[j]);
                if (maxNum - minNum <= limit) {
                    maxLength = Math.max(maxLength, j - i + 1);
                    continue;
                }
                break;
            }
        }
        return maxLength;
    }
}