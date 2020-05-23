package p1451;

import java.util.Arrays;

class Solution {
    public String arrangeWords(String text) {
        String[] splited = text.split(" ");
        String[] temp = new String[splited.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = splited[i].toLowerCase();
        }
        Arrays.sort(temp, (a, b) -> -Integer.compare(b.length(), a.length()));
        String answer = String.join(" ", temp);
        return answer.substring(0, 1).toUpperCase() + answer.substring(1, answer.length());
    }
}