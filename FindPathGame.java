import java.util.*;
class Node {
    Node left;
    Node right;
    int x;
    int y;
    int idx;
    Node(Node left, Node right, int x, int y, int idx) {
        this.left = left;
        this.right = right;
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}
class Solution {
    int[][] answer;
    Node[] nodes;
    int cnt;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        nodes = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(null, null, nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        Arrays.sort(nodes, (o1, o2) -> {
            if(o1.y == o2.y) {
                return o1.x - o2.x;
            }
            return o2.y - o1.y;
        });
        Node parent = nodes[0];
        for(int i = 1; i < nodeinfo.length; i++) {
            insertNode(parent, nodes[i]);
        }
        cnt = 0;
        preOrder(parent);
        cnt = 0;
        postOrder(parent);
        return answer;
    }
    void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        }
        else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }
    void preOrder(Node root) {
        if(root == null) {
            return;
        }
        answer[0][cnt++] = root.idx;
        preOrder(root.left);
        preOrder(root.right);
    }
    void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        answer[1][cnt++] = root.idx;
    }
}