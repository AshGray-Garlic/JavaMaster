class Solution {
    int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        boolean[] visit = new boolean[dungeons.length];
        dfs(dungeons, visit, k, 0);
        return answer;
    }
    void dfs(int[][] dungeons, boolean[] visit, int k, int count) {
        if(answer < count)
            answer = count;
        for(int i = 0; i < dungeons.length; i++) {
            if(!visit[i] && k >= dungeons[i][0]) {
                visit[i] = true;
                dfs(dungeons, visit, k - dungeons[i][1], count + 1);
                visit[i] = false;
            }
        }
    }
}