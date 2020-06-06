package p1464;

import java.util.Arrays;

class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int x = nums[nums.length - 1] - 1;
        int y = nums[nums.length - 2] - 1;
        return x * y;
    }
}