class Time {
    int end;
    int run;
    Time(int end, int run) {
        this.end = end;
        this.run = run;
    }
}
class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        int[] startTime = new int[lines.length];
        int[] endTime = new int[lines.length];
        Time[] process = new Time[lines.length];
        for(int i = 0; i < lines.length; i++) {
            int end = processTime(lines[i]);
            int run = runningTime(lines[i].substring(24, lines[i].length() - 1));
            process[i] = new Time(end, run);
            startTime[i] = end - run + 1;
            endTime[i] = end;
        }
        int cnt = 0;
        for(int i : startTime) {
            cnt = 0;
            for(Time t : process) {
                if(t.end - t.run <= i && i <=t.end) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        for(int i : endTime) {
            answer = Math.max(answer, getCount(process, i));
        }
        return answer;
    }
    int processTime(String str) {
        int time = Integer.parseInt(str.substring(11, 13)) * 3600000
                + Integer.parseInt(str.substring(14, 16)) * 60000
                + Integer.parseInt(str.substring(17, 19)) * 1000
                + Integer.parseInt(str.substring(20, 23));
        return time;
    }
    int runningTime(String str) {
        int running = (int)(Double.parseDouble(str) * 1000);
        return running;
    }
    int getCount(Time[] process, int time) {
        int count1 = 0;
        int count2 = 0;
        for(Time t : process) {
            if(t.end - t.run + 1 <= time && time - 999 <= t.end) {
                count1++;
            }
            if(t.end - t.run + 1 <= time + 999 && time <= t.end) {
                count2++;
            }
        }
        return Math.max(count1, count2);
    }
}