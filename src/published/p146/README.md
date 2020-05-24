# [Leetcode] 146. LRU Cache

`LRU(Least Recently Used) Cache`를 구현한다.

## Solution

높은 성능의 `Cache`를 사용하기 위해서는 `O(1)` 시간에 데이터를 읽고 갱신할 수 있어야 하기 때문에 `Map` 자료구조를 사용해야 한다. 또한 데이터의 사이즈가 `capacity`를 넘어서는 순간에는 가장 `Eldest`한 데이터를 삭제해줘야 하기 때문에 `Queue` 형태의 자료구조를 사용해야 한다. 그렇기 때문에 이번 문제를 풀기 위해서 2가지 기능이 모두 가능한 `LinkedHashMap`을 사용한다.

### LRUCache

생성자를 호출할 때 `LinkedHashMap`을 정의하는데, 이때 `removeEldestEntry` 메소드를 오버라이드하여 데이터의 사이즈가 `capacity` 보다 커질 경우 자동으로 가장 오래된 데이터를 삭제할 수 있게 정의한다.

### get

`LinkedHashMap`에 키값을 가진 데이터가 없다면 `-1`을 반환하고 있다면 데이터를 반환한다. 이때, 데이터의 `LRU` 계수를 높여주기 위해 `LinkedHashMap`에서 해당 데이터를 삭제하고 다시 삽입한다.

### put

`LinkedHashMap`에 데이터를 갱신해줘야 하는데, 이때 데이터가 이미 존재한다면 `LRU` 계수를 높여줘야 하기 때문에 무조건 한 번 삭제하고 데이터를 삽입한다.

```java
class LRUCache {
    private final Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        int ret = cache.getOrDefault(key, -1);
        if (ret != -1) {
            cache.remove(key);
            cache.put(key, ret);
        }
        return ret;
    }

    public void put(int key, int value) {
        cache.remove(key);
        cache.put(key, value);
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(1) | 15 ms | 47.4 MB |
