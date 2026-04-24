class Solution {
    int count;
    public int solution(int n) {
        int answer = 0;
        count = 0;
        dfs(n, 0, 0);
        answer = count;
        return answer;
    }
    void dfs(int n, int left, int right) {
        if(left > n) {
            return;
        }
        if(left == n) {
            count++;
            return;
        }
        if(left < n) {
            for(int i = 0; i <= left - right; i++) {
                dfs(n, left + 1, right + i);
            }
        }
    }
}