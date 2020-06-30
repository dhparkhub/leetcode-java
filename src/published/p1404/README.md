# [Leetcode] 1404. Number of Steps to Reduce a Number in Binary Representation to One

문제의 조건대로 주어진 이진 문자열이 1이 될 때까지 필요한 연산의 횟수를 반환한다.

## Solution

주어진 이진 문자열이 홀수인지 짝수인지 먼저 판별한다. 문자열의 마지막 문자가 `0`이라면 짝수이고, `1`이라면 홀수이다. 짝수면 이진수를 2로 나누어주고 홀수라면 1을 더해 2로 나눌 수 있게 맞춘다.

```java
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
```

2로 나누는 건 마지막 문자인 `0`을 하나 빼주는 것으로 충분한다.

```java
private String divide(String s) {
    return s.substring(0, s.length() - 1);
}
```

1을 더하는 건 문자열에 `0`이 있느냐 없느냐에 따라 다르다. `0`이 존재하면 제일 마지막에 위치한 `0`은 `1`로 변하고 그 이하 수는 전부 `0`이 된다. `0`이 존재하지 않으면 자리수가 올라 `1`이 맨앞에 추가되고 나머지 숫자는 다 `0`이 된다.

```java
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
```

```java
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
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| - | 3 ms | 39.8 MB |
