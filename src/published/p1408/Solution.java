package published.p1408;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (words[i].contains(words[j])) {
                    if (!map.containsKey(words[j])) {
                        answer.add(words[j]);
                        map.put(words[j], true);
                    }
                }
            }
        }
        return answer;
    }
}