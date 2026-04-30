import java.util.*;
class Result {
    boolean win;
    int count;
    Result(boolean win, int count) {
        this.win = win;
        this.count = count;
    }
}
class Solution {
    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { -1, 0, 1, 0 };
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        answer = dfs(board, aloc[1], aloc[0], bloc[1], bloc[0], board.length, board[0].length).count;
        return answer;
    }
    Result dfs(int[][] board, int ax, int ay, int bx, int by, int n, int m) {
        if(board[ay][ax] == 0)
            return new Result(false, 0);
        boolean win = false;
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i < 4; i++) {
            int nx = ax + dx[i];
            int ny = ay + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && board[ny][nx] >= 1) {
                board[ay][ax] = 0;
                Result r = dfs(board, bx, by, nx, ny, n, m);
                board[ay][ax] = 1;
                if(!r.win) {
                    win = true;
                    min = Math.min(min, r.count + 1);
                } else {
                    max = Math.max(max, r.count + 1);
                }
            }
        }
        if(min == Integer.MAX_VALUE && max == 0) {
            return new Result(false, 0);
        } else {
            if(win) {
                return new Result(true, min);
            } else {
                return new Result(false, max);
            }
        }
    }
}