import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        List<List<int[]>> loads = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            loads.add(new ArrayList<>());
        }
        for(int[] fare : fares) {
            loads.get(fare[0] - 1).add(new int[]{fare[1] - 1, fare[2]});
            loads.get(fare[1] - 1).add(new int[]{fare[0] - 1, fare[2]});
        }
        int[] start = new int[n];
        int[] endA = new int[n];
        int[] endB = new int[n];
        Arrays.fill(start, Integer.MAX_VALUE);
        Arrays.fill(endA, Integer.MAX_VALUE);
        Arrays.fill(endB, Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        q.offer(new int[]{s - 1, 0});
        start[s - 1] = 0;
        while(!q.isEmpty()) {
            int[] point = q.poll();
            if(start[point[0]] < point[1]) {
                continue;
            }
            for(int[] next : loads.get(point[0])) {
                if(start[next[0]] > point[1] + next[1]) {
                    start[next[0]] = point[1] + next[1];
                    q.offer(new int[]{next[0], start[next[0]]});
                }
            }
        }
        q.offer(new int[]{a - 1, 0});
        endA[a - 1] = 0;
        while(!q.isEmpty()) {
            int[] point = q.poll();
            if(endA[point[0]] < point[1]) {
                continue;
            }
            for(int[] next : loads.get(point[0])) {
                if(endA[next[0]] > point[1] + next[1]) {
                    endA[next[0]] = point[1] + next[1];
                    q.offer(new int[]{next[0], endA[next[0]]});
                }
            }
        }
        q.offer(new int[]{b - 1, 0});
        endB[b - 1] = 0;
        while(!q.isEmpty()) {
            int[] point = q.poll();
            if(endB[point[0]] < point[1]) {
                continue;
            }
            for(int[] next : loads.get(point[0])) {
                if(endB[next[0]] > point[1] + next[1]) {
                    endB[next[0]] = point[1] + next[1];
                    q.offer(new int[]{next[0], endB[next[0]]});
                }
            }
        }
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(start[i] == Integer.MAX_VALUE || endA[i] == Integer.MAX_VALUE || endB[i] == Integer.MAX_VALUE)
                continue;
            if(answer > start[i] + endA[i] + endB[i]) {
                answer = start[i] + endA[i] + endB[i];
            }
        }
        return answer;
    }
}