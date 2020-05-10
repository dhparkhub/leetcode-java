# [Leetcode] 5. Longest Palindromic Substring

주어진 문자열의 `substring` 중에서 `Palindromic`한 문자열 중 가장 긴 문자열을 반환한다.

## Solution

`Palindrome`은 대칭 구조를 가지는 문자열을 의미하며 문자열의 길이가 홀수인 것과 짝수인 것으로 나눌 수 있다. 문자열의 중심부에서 양쪽으로 인덱스를 옮겨가며 해당 문자열이 `Palindrome`인지 검사할 수 있는데, 주어진 문자열의 문자를 순차적으로 탐색하면서 완전 탐색으로 가능한 모든 경우의 수를 다 찾아, 그 중 가장 긴 `Palindrome`을 반환한다.


```java
class Solution {
    private String s;
    private String answer = "";

    public String longestPalindrome(String s) {
        this.s = s;
        for (int i = 0; i < s.length(); i++) {
            palindromize(i, i);
            palindromize(i, i + 1);
        }
        return answer;
    }

    private void palindromize(int i, int j) {
        if (i < 0) return;
        if (j >= s.length()) return;
        if (s.charAt(i) == s.charAt(j)) {
            String temp = s.substring(i, j + 1);
            if (temp.length() > answer.length()) {
                answer = temp;
            }
            palindromize(i - 1, j + 1);
        }
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N^2) | 277 ms | 40.2 MB |
