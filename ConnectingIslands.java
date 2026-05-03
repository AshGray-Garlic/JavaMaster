import java.util.*;
class Solution {
    int[] linkHead;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        linkHead = new int[n];
        for(int i = 0; i < n; i++) {
            linkHead[i] = i;
        }
        Arrays.sort(costs, (a1, a2) -> a1[2] - a2[2]);
        int count = 0;
        for(int i = 0; i < costs.length; i++) {
            if(union(Math.min(costs[i][0], costs[i][1]), Math.max(costs[i][0], costs[i][1]))) {
                count++;
                answer += costs[i][2];
            }
            if(count == n - 1)
                break;
        }
        return answer;
    }
    int find(int num) {
        if(linkHead[num] == num) {
            return num;
        } else {
            return linkHead[num] = find(linkHead[num]);
        }
    }
    boolean union(int n1, int n2) {
        boolean check = false;
        int root1 = find(n1);
        int root2 = find(n2);
        if(root1 != root2) {
            linkHead[root2] = root1;
            check = true;
        }
        return check;
    }
}