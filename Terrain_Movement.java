import java.util.*;
class Solution {
    int[][] linkHead;
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    public int solution(int[][] land, int height) {
        int answer = 0;
        int len = land.length;
        linkHead = new int[len][len];
        int group = 1;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(linkHead[i][j] == 0) {
                    linkHead[i][j] = group;
                    dfs(land, height, len, i, j, group);
                    group++;
                }
            }
        }
        List<int[]> list = new ArrayList<>();
        for(int r = 0; r < len; r++) {
            for(int c = 0; c < len; c++) {
                for(int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(nr >= 0 && nc >= 0 && nr < len && nc < len && linkHead[r][c] != linkHead[nr][nc]) {
                        list.add(new int[]{r, c, nr, nc, Math.abs(land[r][c] - land[nr][nc])});
                    }
                }
            }
        }
        list.sort((a1, a2) -> {
            return a1[4] - a2[4];
        });
        int[] parent = new int[group];
        for(int i = 0; i < group; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < list.size(); i++) {
            int[] edge = list.get(i);
            int g1 = linkHead[edge[0]][edge[1]];
            int g2 = linkHead[edge[2]][edge[3]];
            int cost = edge[4];
            if(find(parent, g1) != find(parent, g2)) {
                union(parent, g1, g2);
                answer += cost;
            }
        }
        return answer;
    }
    int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }
    void union(int[] parent, int n1, int n2) {
        int r1 = find(parent, n1);
        int r2 = find(parent, n2);
        if (r1 != r2) {
            parent[r2] = r1;
        }
    }
    void dfs(int[][] land, int height, int len, int r, int c, int group) {
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nc >= 0 && nr < len && nc < len && linkHead[nr][nc] == 0) {
                if(Math.abs(land[r][c] - land[nr][nc]) <= height) {
                    linkHead[nr][nc] = group;
                    dfs(land, height, len, nr, nc, group);
                }
            }
        }
    }
}