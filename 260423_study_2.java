class Solution {
    int count;
    public int solution(int n) {
        int answer = 0;
        count = 0;
        highVoice(n, 0);
        answer = count;
        return answer;
    }
    void highVoice(int n, int plus) {
        if(n < 3) {
            if(n == 1 && plus == 0)
                count++;
            return;
        }
        if(Math.log(n) / Math.log(3) * 2 < plus) {
            return;
        }
        if(n % 3 == 0 && plus >= 2) {
            highVoice(n / 3, plus - 2);
        }
        highVoice(n - 1, plus + 1);
    }
}