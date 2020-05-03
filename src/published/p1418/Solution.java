package published.p1418;

import java.util.*;

class Solution {
    Set<Integer> allTable = new TreeSet<>();
    Set<String> allMenus = new TreeSet<>();
    Map<String, List<String>> orderMap = new HashMap<>();

    public List<List<String>> displayTable(List<List<String>> orders) {
        for (int i = 0; i < orders.size(); i++) {
            List<String> order = orders.get(i);
            // String orderer = order.get(0);
            String tableNum = order.get(1);
            String menu = order.get(2);

            allTable.add(Integer.parseInt(tableNum));
            allMenus.add(menu);
            if (orderMap.containsKey(tableNum)) {
                orderMap.get(tableNum).add(menu);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(menu);
                orderMap.put(tableNum, tempList);
            }
        }

        List<List<String>> answer = new ArrayList<>();

        List<String> tableHeader = new ArrayList<>();
        tableHeader.add("Table");
        tableHeader.addAll(allMenus);
        answer.add(tableHeader);

        allTable.forEach(tableNum -> {
            List<String> tempList = new ArrayList<>();
            tempList.add(String.valueOf(tableNum));
            List<String> orderMenu = orderMap.get(String.valueOf(tableNum));
            allMenus.forEach(menu -> {
                int count = 0;
                for (String s : orderMenu) {
                    if (menu.equals(s)) {
                        count++;
                    }
                }
                tempList.add(String.valueOf(count));
            });
            answer.add(tempList);
        });

        return answer;
    }
}