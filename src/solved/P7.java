package solved;

public class P7 {

    class Solution {
        public int reverse(int x) {
            long answer = 0;
            while (x != 0) {
                answer = answer * 10 + x % 10;
                x /= 10;
            }
            return answer == (int) answer ? (int) answer : 0;// prevent overflow
        }
    }

}