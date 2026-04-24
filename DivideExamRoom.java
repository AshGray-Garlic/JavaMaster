import java.util.*;
class Solution {
    int max;
    int now;
    int[] people;
    public int solution(int k, int[] num, int[][] links) {
        int answer = 0;
        max = k;
        int n = num.length;
        boolean[] findRoot = new boolean[n];
        for(int i = 0; i < links.length; i++) {
            if(links[i][0] != -1)
                findRoot[links[i][0]] = true;
            if(links[i][1] != -1)
                findRoot[links[i][1]] = true;
        }
        int root = 0;
        for(int i = 0; i < findRoot.length; i++) {
            if(!findRoot[i]) {
                root = i;
                break;
            }
        }
        int low = 1;
        for(int i : num) {
            low = Math.max(low, i);
        }
        int high = num.length * 10000;
        while(low <= high) {
            int mid = (low + high) / 2;
            now = 1;
            people = new int[n];
            cutLine(links, num, root, mid);
            if(now > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
    int cutLine(int[][] links, int[] num, int idx, int mid) {
        int left = 0, right = 0;
        if(links[idx][0] != -1)
            left = cutLine(links, num, links[idx][0], mid);
        if(links[idx][1] != -1)
            right = cutLine(links, num, links[idx][1], mid);
        if(left + right + num[idx] <= mid) {
            return people[idx] = left + right + num[idx];
        }
        if(num[idx] + Math.min(left, right) <= mid) {
            now += 1;
            return num[idx] + Math.min(left, right);
        }
        now += 2;
        return num[idx];
    }
}