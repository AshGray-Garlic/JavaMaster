class Solution {
    int[][] map;
    boolean[][] visit;
    int min;
    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { 1, 0, -1, 0 };
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[101][101];
        visit = new boolean[101][101];
        drawRect(rectangle);
        min = Integer.MAX_VALUE;
        dfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2, 0);
        answer = min / 2;
        return answer;
    }
    void drawRect(int[][] rectangle) {
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i > x1 && i < x2 && j > y1 && j < y2) {
                        map[i][j] = 2;
                    }
                    else {
                        if (map[i][j] != 2) {
                            map[i][j] = 1;
                        }
                    }
                }
            }
        }
    }
    void dfs(int x, int y, int itemX, int itemY, int count) {
        if(map[x][y] != 1)
            return;
        if(min <= count)
            return;
        if(x == itemX && y == itemY) {
            min = count;
            return;
        }
        visit[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx <= 100 && ny <= 100) {
                if(!visit[nx][ny]) {
                    dfs(nx, ny, itemX, itemY, count + 1);
                }
            }
        }
    }
}