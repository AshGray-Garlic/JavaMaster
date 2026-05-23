import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        boolean[] useB = new boolean[B.length];
        Arrays.sort(B);
        for(int i = 0; i < A.length; i++) {
            int min = 0;
            int max = B.length - 1;
            int target = -1;
            while(true) {
                if(min > max)
                    break;
                int mid = (min + max) / 2;
                if(B[mid] <= A[i]) {
                    min = mid + 1;
                } else {
                    target = mid;
                    max = mid - 1;
                }
            }
            while(target != -1) {
                if(useB[target]) {
                    target++;
                } else {
                    break;
                }
                if(target >= useB.length) {
                    target = -1;
                    break;
                }
            }
            if(target != -1) {
                useB[target] = true;
                answer++;
            }
        }
        return answer;
    }
}