class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int n = matrix_sizes.length;
        int[][] cal = new int[n][n];
        for(int len = 1; len < n; len++) {
            for(int i = 0; i + len < n; i++) {
                int j = i + len;
                cal[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    int cost = cal[i][k] + cal[k + 1][j] + (matrix_sizes[i][0] * matrix_sizes[k][1] * matrix_sizes[j][1]);
                    cal[i][j] = Math.min(cal[i][j], cost);
                }
            }
        }
        answer = cal[0][n - 1];
        return answer;
    }
}