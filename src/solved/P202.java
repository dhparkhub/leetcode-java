package solved;

import java.util.HashMap;
import java.util.Map;

public class P202 {

    class Solution {
        public boolean isHappy(int n) {
            Map<Integer, Boolean> map = new HashMap<>();
            while (!map.containsKey(n = cycle(n))) {
                if (n == 1) return true;
                map.put(n, true);
            }
            return false;
        }

        private int cycle(int n) {
            int ret = 0;
            while (n != 0) {
                ret += Math.pow(n % 10, 2);
                n /= 10;
            }
            return ret;
        }
    }

}
