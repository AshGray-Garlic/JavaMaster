import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < survey.length; i++) {
            switch(choices[i]) {
                case 1:
                    map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0) + 3);
                    break;
                case 2:
                    map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0) + 2);
                    break;
                case 3:
                    map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0) + 1);
                    break;
                case 6:
                    map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0) + 2);
                    break;
                case 7:
                    map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0) + 3);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? "R" : "T");
        sb.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? "C" : "F");
        sb.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? "J" : "M");
        sb.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? "A" : "N");
        answer = sb.toString();
        return answer;
    }
}