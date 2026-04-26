class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] right_min = new int [a.length];
        int[] left_min = new int [a.length];

        for(int i = 0; i < a.length; i++) {
            if(i == 0) {
                left_min[i] = a[0];
                right_min[a.length - 1] = a[a.length - 1];
            } else {
                left_min[i] = Math.min(left_min[i - 1], a[i - 1]);
                right_min[a.length - 1 - i] = Math.min(right_min[a.length - i], a[a.length - i]);
            }
        }

        for(int i = 0; i < a.length; i++) {
            if(right_min[i] >= a[i] || left_min[i] >= a[i]){
                answer++;
            }
        }
        return answer;
    }
}