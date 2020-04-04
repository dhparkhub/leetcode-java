package solved;

import java.util.LinkedList;
import java.util.List;

public class P1389 {

    class Solution {
        public int[] createTargetArray(int[] nums, int[] index) {
            init();
            for (int i = 0; i < nums.length; i++) {
                targetList.add(index[i], nums[i]);
            }
            return targetList.stream().mapToInt(i->i).toArray();
        }

        void init() {
            targetList = new LinkedList<>();
        }

        private List<Integer> targetList;
    }

}
