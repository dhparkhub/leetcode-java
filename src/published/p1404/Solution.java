package published.p1404;

class Solution {
    public int numSteps(String s) {
        int answer = 0;
        while (!s.equals("1")) {
            int lastIndex = s.length() - 1;
            if (s.charAt(lastIndex) == '0') {
                s = divide(s);
            } else {
                s = add(s);
            }
            answer++;
        }
        return answer;
    }

    private String divide(String s) {
        return s.substring(0, s.length() - 1);
    }

    private String add(String s) {
        StringBuilder ret;
        int pos = s.lastIndexOf('0');
        if (pos == -1) {
            ret = new StringBuilder("1");
            for (int i = 0; i < s.length(); i++) {
                ret.append('0');
            }
        } else {
            ret = new StringBuilder(s.substring(0, pos) + "1");
            for (int i = pos + 1; i < s.length(); i++) {
                ret.append('0');
            }
        }
        return ret.toString();
    }
}