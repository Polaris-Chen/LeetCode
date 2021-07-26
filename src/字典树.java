import java.util.HashMap;
import java.util.Map;

public class 字典树 {
//https://blog.csdn.net/xd_fybdw/article/details/81149742
//Trie树，即字典树，又称单词查找树或键树，是一种树形结构，是一种哈希树的变种。
// 典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。
//Trie的核心思想是空间换时间。利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。


    public static void main(String[] args) {
        String[] x=new String[]{"192.168.1.1","192.168.3.4","192.168.3.1","11.10.2.4"};
        String[] y=new String[]{"192.168.1.1","192.168.3.4","192.168.3.1","1.10.2.4","11.23.44.11"};
        judge(x,y);

    }

    public static void judge(String[] x,String[] y){
        TrieTree t=new TrieTree();
        for (int i=0;i<y.length;i++){
            t.add(y[i]);
        }
        boolean[] z=new boolean[x.length];
        System.out.print("[");
        for (int j=0;j<x.length-1;j++){
            System.out.print(t.query(x[j])+",");
        }
        System.out.print(t.query(x[x.length-1])+"]");

    }
    static class  TrieNode {
        char ch;

        Map<Character, TrieNode> nodeMap;

        public TrieNode(char ch, Map<Character, TrieNode> nodeMap) {
            this.ch = ch;
            this.nodeMap = nodeMap;
        }
    }

    public static class TrieTree {
        private TrieNode root;

        public TrieTree() {
            root = new TrieNode('\u0000', new HashMap<Character, TrieNode>());
        }

        /**
         * 查询str字符串是否存在
         *
         * @param str
         * @return
         */
        public boolean query(String str) {
            TrieNode cur = root;
            if (root == null) {
                return false;
            }
            for (int i = 0; i < str.length(); i++) {
                TrieNode child = cur.nodeMap.get(str.charAt(i));
                if (child == null) {
                    return false;
                } else {
                    cur = child;
                }
            }
            return true;
        }

        /**
         * 添加单词
         */
        public void add(String str) {
            //System.out.println(str);
            TrieNode cur = root;
            if (root == null) {
                return;
            }
            for (int i = 0; i < str.length(); i++) {
                TrieNode child = cur.nodeMap.get(str.charAt(i));
                if (child == null) {
                    TrieNode node = new TrieNode(str.charAt(i), new HashMap<Character, TrieNode>());

                    cur.nodeMap.put(str.charAt(i), node);
                    cur = cur.nodeMap.get(str.charAt(i));
                } else {

                    cur = child;
                }
            }

        }
    }
}
