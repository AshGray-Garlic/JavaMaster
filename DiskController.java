import java.util.*;
class Node implements Comparable<Node> {
    int idx;
    int start;
    int time;
    Node(int idx, int start, int time) {
        this.idx = idx;
        this.start = start;
        this.time = time;
    }
    @Override
    public int compareTo(Node o) {
        if(this.time == o.time) {
            if(this.start == o.start) {
                return this.idx - o.idx;
            } else {
                return this.start - o.start;
            }
        } else {
            return this.time - o.time;
        }
    }
}
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int idx = 0;
        int cnt = 0;
        Arrays.sort(jobs, ((i1, i2) -> i1[0] - i2[0]));
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int now = 0;
        while(cnt < jobs.length) {
            while(cnt < jobs.length && jobs[cnt][0] <= now) {
                pq.offer(new Node(cnt, jobs[cnt][0], jobs[cnt][1]));
                cnt++;
            }
            if(pq.isEmpty()) {
                now = jobs[cnt][0];
            } else {
                Node node = pq.poll();
                now += node.time;
                answer += now - node.start;
            }
        }
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            now += node.time;
            answer += now - node.start;
        }
        answer /= jobs.length;
        return answer;
    }
}