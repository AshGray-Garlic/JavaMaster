class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int len = arr.length / 2 + 1;
        char[] cal = new char[arr.length / 2];
        int[][][] dp = new int[len][len][2];
        for(int i = 1; i < arr.length; i += 2) {
            cal[i / 2] = arr[i].charAt(0);
        }
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(i == j) {
                    dp[i][j][0] = dp[i][j][1] = Integer.parseInt(arr[i * 2]);
                } else {
                    dp[i][j][0] = Integer.MAX_VALUE;
                    dp[i][j][1] = Integer.MIN_VALUE;
                }
            }
        }
        for(int d = 1; d < len; d++) {
            for(int i = 0; i < len - d; i++) {
                int j = d + i;
                for(int k = i; k < j; k++) {
                    if(cal[k] == '+') {
                        dp[i][j][0] = Math.min(dp[i][j][0], dp[i][k][0] + dp[k + 1][j][0]);
                        dp[i][j][1] = Math.max(dp[i][j][1], dp[i][k][1] + dp[k + 1][j][1]);
                    } else {
                        dp[i][j][0] = Math.min(dp[i][j][0], dp[i][k][0] - dp[k + 1][j][1]);
                        dp[i][j][1] = Math.max(dp[i][j][1], dp[i][k][1] - dp[k + 1][j][0]);
                    }
                }
            }
        }
        answer = dp[0][len - 1][1];
        return answer;
    }
}