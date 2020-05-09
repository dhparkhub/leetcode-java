package published.p1437;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int tempIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (tempIndex == -1) {
                    tempIndex = i;
                    continue;
                }
                minLength = Math.min(minLength, i - tempIndex - 1);
                if (minLength < k) return false;
                tempIndex = i;
            }
        }
        return true;
    }
}

//import java.util.ArrayList;
//import java.util.List;
//
//class Solution {
//    public boolean kLengthApart(int[] nums, int k) {
//        List<Integer> tempList = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 1) {
//                tempList.add(i);
//            }
//        }
//
//        int tempLength = Integer.MAX_VALUE;
//        for (int i = 0; i < tempList.size() - 1; i++) {
//            tempLength = Math.min(tempLength, tempList.get(i + 1) - tempList.get(i) - 1);
//            if (tempLength < k) return false;
//        }
//
//        return true;
//    }
//}