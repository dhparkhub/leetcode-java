# [Leetcode] 207. Course Schedule

수강 가능한 과목과 선수강이 필요한 과목 간의 관계가 주어지고 모든 과목을 수강할 수 있는지 그 여부를 반환한다.

## Solution

위상 정렬을 이용하여 문제를 해결할 수 있다.

### 위상 저장

과목의 위상을 저장할 수 있게 배열을 선언한다. 과목 간의 관계를 순차적으로 탐색하면서 선수강이 필요한 과목이 나올 때마다 해당 과목의 위상을 1씩 증가시켜준다.

### 위상 정렬

수강할 수 있는 과목 중 위상이 0인 과목을 수강한다. 이 문제에서는 위상을 `-1`로 만들어주는 것으로 중복을 피했다. 위상이 0인 과목을 수강하는 동시에, 해당 과목의 선수강이 필요한 과목의 위상을 1씩 감소시킨다. 위상이 줄어든 과목 중 위상이 0인 과목이 있으면 전의 과정을 반복하여 모든 과목을 수강하면 `true`를 반환한다. 수강할 수 있는 과목을 찾던 중 어떠한 과목도 수강할 수 없으면 더 이상 수강할 수 있는 과목이 없으므로 `false`를 반환한다.

```java
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] topology = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            topology[x]++;
            graph.get(y).add(x);
        }

        int count = 0;
        while (count < numCourses) {
            boolean courseTaken = false;
            for (int i = 0; i < numCourses; i++) {
                if (topology[i] == 0) {
                    List<Integer> list = graph.get(i);
                    for (Integer x : list) {
                        topology[x]--;
                    }
                    topology[i]--;
                    courseTaken = true;
                    count++;
                }
            }
            if (!courseTaken) break;
        }

        return count == numCourses;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N^2) | 5 ms | 39.6 MB |
