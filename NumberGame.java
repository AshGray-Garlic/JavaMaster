import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int cntA = 0;
        int cntB = 0;
        while(cntA < A.length && cntB < B.length) {
            if(A[cntA] < B[cntB]) {
                cntA++;
                answer++;
            }
            cntB++;
        }
        return answer;
    }
}