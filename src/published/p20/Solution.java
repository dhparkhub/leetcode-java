package p20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    private final Stack<Character> stack = new Stack<>();
    private final Map<Character, Character> map = new HashMap<>();

    public Solution() {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public boolean isValid(String s) {
        for (char x : s.toCharArray()) {
            if (map.containsKey(x)) {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (x == map.get(stack.peek())) {
                stack.pop();
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }
}
