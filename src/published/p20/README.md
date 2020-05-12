# [Leetcode] 20. Valid Parentheses

주어진 괄호 문자열이 정상적인지 판별하는 문제이다.

## Solution

주어진 문자열을 탐색하면서 여는 괄호가 나오면 스택에 데이터를 쌓아둔다. 닫는 괄호가 나오면 스택에서 데이터를 하나 꺼내어 괄호의 짝이 맞는지 확인한다. 문자열 탐색이 끝나고 `())))` 같은 경우처럼 스택이 남아있을 수 있으니, 스택이 비어있는지 반드시 확인한다.

```java
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
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 1 ms | 37.1 MB |
