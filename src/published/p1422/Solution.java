package published.p1422;

class Solution {
    public int maxScore(String s) {
        int rightScore = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') rightScore++;
        }
        int answer = 0;
        int leftScore = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftScore++;
            } else {
                rightScore--;
            }
            answer = Math.max(answer, leftScore + rightScore);
        }
        return answer;
    }
}

//class Solution {
//    public int maxScore(String s) {
//        int answer = 0;
//        for (int i = 1; i < s.length(); i++) {
//            String left = s.substring(0, i);
//            String right = s.substring(i, s.length());
//            int score = 0;
//            for (char ch : left.toCharArray()) {
//                if (ch == '0') {
//                    score++;
//                }
//            }
//            for (char ch : right.toCharArray()) {
//                if (ch == '1') {
//                    score++;
//                }
//            }
//            answer = Math.max(answer, score);
//        }
//        return answer;
//    }
//}