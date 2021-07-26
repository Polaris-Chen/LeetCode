package LeetCode;

public class _116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        aux_connect(root.left,root.right);
        return root;
    }
    public void aux_connect(Node a,Node b) {
        if (a==null||b==null){
            return;
        }
        a.next=b;
        aux_connect(a.left,a.right);
        aux_connect(b.left,b.right);
        aux_connect(a.right,b.left);
    }
}
