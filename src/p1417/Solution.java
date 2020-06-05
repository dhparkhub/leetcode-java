package p1417;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String reformat(String s) {
        Queue<Character> chStack = new LinkedList<>();
        Queue<Character> intStack = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                chStack.add(ch);
            } else {
                intStack.add(ch);
            }
        }

        if (Math.abs(chStack.size() - intStack.size()) > 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = chStack.size() >= intStack.size();
        while (!chStack.isEmpty() || !intStack.isEmpty()) {
            if (flag) {
                sb.append(chStack.remove());
            } else {
                sb.append(intStack.remove());
            }
            flag = !flag;
        }

        return sb.toString();
    }
}