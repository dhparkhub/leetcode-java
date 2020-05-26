package published.p1452;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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