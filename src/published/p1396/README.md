# [Leetcode] 1396. Design Underground System

`Underground System`의 `checkIn`, `checkOut`, `getAverageTime` 메소드를 구현한다.

## Solution

이용자의 출발역과 출발 시간을 저장하는 `checkIn` 클래스와 출발역에서 도착역까지의 총 소요시간과 해당 루트를 이용한 이용자의 수를 저장하는 `checkOut` 클래스를 설계한다. 

### checkIn

이용자의 아이디 값을 키값으로 하여 이용자의 출발역과 출발 시간을 맵에 저장한다.

### checkOut

이용자의 아이디 값을 사용하여 이용자의 체크인 데이터를 가져오고, `출발역-도착역`을 키값으로 하여 해당 루트를 한 이용자를 카운트하고 총 소요 시간을 저장한다.

### getAverageTime

`출발역-도착역`을 키값으로 해당 루트의 총 소요시간을 해당 루트를 이용한 사람의 수로 나눈 값을 반환한다.

```java
import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    class CheckInInfo {
        private String stationName;
        private int t;

        CheckInInfo(String stationName, int t) {
            this.stationName = stationName;
            this.t = t;
        }
    }

    class CheckOutInfo {
        private int total;
        private int count;

        CheckOutInfo(int total, int count) {
            this.total = total;
            this.count = count;
        }
    }

    private final Map<Integer, CheckInInfo> checkInMap = new HashMap<>();
    private final Map<String, CheckOutInfo> checkOutMap = new HashMap<>();

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkInInfo = checkInMap.get(id);
        String checkOutKey = String.format("%s-%s", checkInInfo.stationName, stationName);
        if (!checkOutMap.containsKey(checkOutKey)) {
            checkOutMap.put(checkOutKey, new CheckOutInfo(t - checkInInfo.t, 1));
        } else {
            checkOutMap.get(checkOutKey).total += t - checkInInfo.t;
            checkOutMap.get(checkOutKey).count += 1;
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String checkOutKey = String.format("%s-%s", startStation, endStation);
        CheckOutInfo checkOutInfo = checkOutMap.get(checkOutKey);
        return (double) checkOutInfo.total / checkOutInfo.count;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(1) | 123 ms | 53.7 MB |
