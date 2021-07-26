package 剑指offer;
// 我刚开始的想法是先把左右都搞好,在连接左右,整体逻辑非常复杂
//大佬的想法就是更简单,每次只处理根节点,其实这才是对的,我又想在一次迭代里做太多东西了
//每次只加入根节点,把尾结点的right指向root,root指向尾结点,再移动尾结点的位置
//单次迭代做的事情要尽可能的少,尽可能的简单.
public class offer_36_二叉搜索树与双向链表_imprtant {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    Node head,tail;
    public Node treeToDoublyList(Node root) {
        if (root==null){
            return null;
        }
        aux_treeToDoublyList(root);
        head.left=tail;
        tail.right=head;
        return head;
    }
    public void aux_treeToDoublyList(Node root) {
            if (root==null){
                return;
            }
            aux_treeToDoublyList(root.left);
            if (tail!=null) {
                tail.right = root;
                root.left=tail;
            }
            else {
                head=root;
            }
            tail=root;
            aux_treeToDoublyList(root.right);

    }
}
