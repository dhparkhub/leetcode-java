package solved;

import java.util.ArrayList;
import java.util.List;

public class P1395 {

    class Solution {
        public int numTeams(int[] rating) {
            init(rating);
            pickThreeSoliders(0, new ArrayList<>());
            return answer;
        }

        public void pickThreeSoliders(int index, List<Integer> picked) {
            if (picked.size() == 3) {
                if (picked.get(0) < picked.get(1) && picked.get(1) < picked.get(2)) {
                    answer++;
                } else if (picked.get(0) > picked.get(1) && picked.get(1) > picked.get(2)) {
                    answer++;
                }
                return;
            }

            if (index == rating.length) return;

            pickThreeSoliders(index + 1, new ArrayList<>(picked));

            List<Integer> list = new ArrayList<>(picked);
            list.add(rating[index]);
            pickThreeSoliders(index + 1, list);
        }

        public void init(int[] rating) {
            answer = 0;
            this.rating = rating;
        }

        private int answer;
        private int[] rating;
    }

}
