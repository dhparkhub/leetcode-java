package p1450;

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime < startTime[i]) continue;
            if (queryTime > endTime[i]) continue;
            count++;
        }
        return count;
    }
}
