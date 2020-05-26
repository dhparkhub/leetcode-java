# [Leetcode] 1452. People Whose List of Favorite Companies Is Not a Subset of Another List

임의의 사람이 좋아하는 회사의 집합이 다른 사람이 좋아하는 회사의 부분 집합이 아닌 리스트를 반환한다.

## Solution

사람들이 좋아하는 회사 전체를 카운트한다. 만약 임의의 사람이 좋아하는 회사들 중 하나라도 카운트가 1인, 즉 다른 사람에게 없는 회사가 나오면 리스트에 추가한다. 다음으로 반복문을 돌면서 다른 사람들이 좋아하는 회사 리스트와 비교하여 부분집합인지 검사 후 부분집합이 아니라고 판명이 나면 리스트에 추가한다.

```java
class Solution {
    private final Map<String, Integer> companyMap = new HashMap<>();

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        for (List<String> companyList : favoriteCompanies) {
            for (String company : companyList) {
                companyMap.put(company, companyMap.getOrDefault(company, 0) + 1);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> companyList = favoriteCompanies.get(i);

            boolean hasUniqueCompany = false;
            for (String company : companyList) {
                if (companyMap.get(company) == 1) {
                    hasUniqueCompany = true;
                    break;
                }
            }

            if (hasUniqueCompany)  {
                answer.add(i);
                continue;
            }

            boolean isSubset = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i == j) continue;
                if (companyList.size() > favoriteCompanies.get(j).size()) continue;
                if (favoriteCompanies.get(j).containsAll(companyList)) {
                    isSubset = true;
                    break;
                }
            }

            if (!isSubset) {
                answer.add(i);
            }
        }

        return answer;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| - | 125 ms | 48.4 MB |
