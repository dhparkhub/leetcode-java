package p33;

import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int numsLength = nums.length;

        // ascending case
        if (nums[0] < nums[nums.length - 1]) {
            int index = Arrays.binarySearch(nums, 0, numsLength, target);// O(logN)
            return index >= 0 ? index : -1;
        }

        // find pivot number
        int l = 0, r = numsLength - 1;
        while (l + 1 < r) {
            int m = (l + r) / 2;
            if (nums[m] > nums[numsLength - 1]) {
                l = m;
                continue;
            }
            r = m;
        }

        int index1 = Arrays.binarySearch(nums, 0, l + 1, target);// O(logN)
        if (index1 >= 0) return index1;

        int index2 = Arrays.binarySearch(nums, l + 1, numsLength, target);// O(logN)
        if (index2 >= 0) return index2;

        return -1;
    }
}
