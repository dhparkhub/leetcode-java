package published.p20;

import java.util.Stack;

class Solution {
    private Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        for (char x : s.toCharArray()) {
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (x == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            if (x == ']' && stack.peek() == '[') {
                stack.pop();
                continue;
            }
            if (x == '}' && stack.peek() == '{') {
                stack.pop();
                continue;
            }
            return false;
        }
        // check remaining data
        return stack.isEmpty();
    }
}
