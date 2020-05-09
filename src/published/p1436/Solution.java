package published.p1436;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private final Map<String, Integer> map = new HashMap<>();

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