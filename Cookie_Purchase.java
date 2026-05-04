class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        for(int i = 0; i < cookie.length - 1; i++) {
            int left = i;
            int right = i + 1;
            int sum_left = cookie[left];
            int sum_right = cookie[right];
            while(true) {
                if(sum_left == sum_right && answer < sum_left) {
                    answer = sum_left;
                }
                if(sum_left <= sum_right && left > 0) {
                    left--;
                    sum_left += cookie[left];
                } else if(sum_left > sum_right && right < cookie.length - 1) {
                    right++;
                    sum_right += cookie[right];
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}