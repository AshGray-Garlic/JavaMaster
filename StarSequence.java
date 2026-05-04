import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] a) {
        int answer = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        for(Map.Entry<Integer, Integer> entry : list) {
            int key = entry.getKey();
            int count = entry.getValue();

            if(count * 2 <= answer)
                continue;
            int s_count = 0;
            for(int i = 0; i < a.length - 1; i++) {
                if(a[i] != a[i + 1] && (a[i] == key || a[i + 1] == key)) {
                    s_count += 2;
                    i++;
                }
            }
            answer = Math.max(answer, s_count);
        }
        return answer;
    }
}