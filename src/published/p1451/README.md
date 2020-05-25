# [Leetcode] 1451. Rearrange Words in a Sentence

주어진 문장을 스페이스로 분리하여 길이가 짧은 순서로 재조합한 뒤 반환한다.

## Solution

`split()` 메소드를 사용하여 스페이스 문자를 기준으로 문자열을 자른 뒤 소문자로 배열에 담는다. `Arrays.sort()` 메소드를 사용하되 `Comparator`를 재정의하여 문자열의 길이가 짧은 순서대로 배열을 정렬한다. `String.join()` 메소드를 사용하여 문자열 배열을 하나의 문자열로 합친 뒤, 맨 앞자리 문자만 대문자로 바꾸어 반환한다.

```java
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
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| - | 22 ms | 40.4 MB |
