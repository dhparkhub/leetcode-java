package p1465;

import java.util.Arrays;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxHeight = horizontalCuts[0];
        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        maxHeight = Math.max(maxHeight, h - horizontalCuts[horizontalCuts.length - 1]);

        long maxWidth = verticalCuts[0];
        for (int i = 0; i < verticalCuts.length - 1; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i + 1] - verticalCuts[i]);
        }
        maxWidth = Math.max(maxWidth, w - verticalCuts[verticalCuts.length - 1]);

        return (int) ((maxHeight * maxWidth) % 1000000007);
    }
}