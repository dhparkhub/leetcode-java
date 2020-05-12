package solved.p1424;

import java.util.*;

class Solution {
    private final Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int totalSize = 0;
        for (int i = 0; i < nums.size(); i++) {
            totalSize += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new LinkedList<>());
                }
                map.get(i + j).addFirst(nums.get(i).get(j));
            }
        }

        int[] answer = new int[totalSize];
        int index = 0;
        for (int key : map.keySet()) {
            for (int i : map.get(key)) {
                answer[index++] = i;
            }
        }

        return answer;
    }
}