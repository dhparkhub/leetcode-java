# [Leetcode] 1436. Destination City

마지막으로 방문할 도시를 반환한다.

## Solution

`paths` 리스트는 출발지와 도착지에 대한 정보를 제공한다. 처음으로 출발하는 도시와 마지막으로 도착할 도시는 1번씩만 제공되고 나머지 도시는 중간 지점이기 때문에 2번씩 출발한다. 출발지에는 `+1`을 해주고 도착지에는 `-1`을 해주면 마지막으로 도착하는 도시는 항상 `-1`의 값을 가지게 된다.

```java
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    private final Map<String, Integer> map = new TreeMap<>();

    public String destCity(List<List<String>> paths) {
        for (List<String> path : paths) {
            String srcCity = path.get(0);
            String destCity = path.get(1);
            map.put(srcCity, map.containsKey(srcCity) ? map.get(srcCity) + 1 : 1);
            map.put(destCity, map.containsKey(destCity) ? map.get(destCity) + -1 : -1);
        }
        for (String city : map.keySet()) {
            if (map.get(city) == -1) {
                return city;
            }
        }
        return null;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 3 ms | 38.7 MB |
