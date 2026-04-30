import java.util.*;
class Node {
    String refereal_name;
    int sell;
    Node(String refereal_name, int sell) {
        this.refereal_name = refereal_name;
        this.sell = sell;
    }
}
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        Map<String, Node> list = new HashMap<>();
        for(int i = 0; i < referral.length; i++) {
            list.put(enroll[i], new Node(referral[i], 0));
        }
        for(int i = 0; i < seller.length; i++) {
            Add(list, seller[i], amount[i] * 100);
        }
        answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = list.get(enroll[i]).sell;
        }
        return answer;
    }
    void Add(Map<String, Node> list, String name, int price) {
        if(name.equals("-") || price == 0) {
            return;
        }
        list.get(name).sell += price - (price / 10);
        Add(list, list.get(name).refereal_name, price / 10);
    }
}