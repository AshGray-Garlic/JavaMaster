class Trie {
    Trie[] child = new Trie[26];
    int count = 0;
}
class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Trie root = new Trie();
        for(String word : words) {
            Trie tmp = root;
            for(char ch : word.toCharArray()) {
                int index = ch - 'a';
                if(tmp.child[index] == null) {
                    tmp.child[index] = new Trie();
                }
                tmp = tmp.child[index];
                tmp.count++;
            }
        }
        for (String word : words) {
            Trie tmp = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                tmp = tmp.child[index];
                answer++;
                if (tmp.count == 1) {
                    break;
                }
            }
        }
        return answer;
    }
}