import java.util.*;
class Solution {
    int[][] prices;
    List<Integer>[] link;
    int result;
    int[] sale;
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        result = 0;
        prices = new int[sales.length][2];
        sale = sales;
        link = new List[sales.length];
        for(int i = 0; i < sales.length; i++) {
            link[i] = new ArrayList<>();
        }
        for(int[] tmp : links) {
            link[tmp[0] - 1].add(tmp[1] - 1);
        }
        dfs(0);
        answer = Math.min(prices[0][0], prices[0][1]);
        return answer;
    }
    void dfs(int idx) {
        if(link[idx].isEmpty()) {
            prices[idx][0] = 0;
            prices[idx][1] = sale[idx];
            return;
        }
        int non = 0;
        boolean attend = false;
        for(int i : link[idx]) {
            dfs(i);
            non += Math.min(prices[i][0], prices[i][1]);
            if(prices[i][1] <= prices[i][0])
                attend = true;
        }
        if(attend) {
            prices[idx][0] = non;
        } else {
            int min_price = Integer.MAX_VALUE;
            for(int i : link[idx]) {
                min_price = Math.min(min_price, prices[i][1] - prices[i][0]);
            }
            prices[idx][0] = non + min_price;
        }
        prices[idx][1] = non + sale[idx];
    }
}