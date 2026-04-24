import java.util.*;

class Solution {
    HashMap<String, ArrayList<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        answer = new int[query.length];
        map = new HashMap<>();
        for(String str : info) {
            String[] div = str.split(" ");
            makeInfo(div, "", 0, Integer.parseInt(div[4]));
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for(int i = 0; i < query.length; i++) {
            String[] div = query[i].split(" and ");
            String[] getScore = div[3].split(" ");
            String key = div[0] + div[1] + div[2] + getScore[0];
            int sc = Integer.parseInt(getScore[1]);
            if(map.containsKey(key))
                answer[i] = binarySearch(map.get(key), sc);
        }

        return answer;
    }

    int binarySearch(ArrayList<Integer> list, int targetScore) {
        int start = 0;
        int end = list.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= targetScore) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return list.size() - start;
    }

    void makeInfo(String[] divInfo, String str, int index, int score) {
        if(index >= 4) {
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(score);
            return;
        } else {
            makeInfo(divInfo, str + divInfo[index], index + 1, score);
            makeInfo(divInfo, str + "-", index + 1, score);
        }
    }
}