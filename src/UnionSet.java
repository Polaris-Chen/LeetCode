import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author polarisChen
 * @create 2021/6/20 7:27 下午
 */
public class UnionSet<V> {
    class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public Map<Element<V>, Element<V>> faterMap;
    public Map<Element<V>, Integer> sizeMap;
    public Map<V, Element<V>> valueMap;

    public UnionSet(List<V> initList){
        init(initList);
    }
    public void init(List<V> initList) {
        faterMap = new HashMap<>();
        sizeMap = new HashMap<>();
        valueMap = new HashMap<>();
        for (V v : initList) {
            Element<V> ev = new Element(v);
            faterMap.put(ev, ev);
            sizeMap.put(ev, 1);
            valueMap.put(v, ev);
        }

    }

    public Element<V> findHead(Element<V> e) {
        Stack<Element<V>> stack = new Stack<>();
        while (!faterMap.get(e).equals(e)) {
            stack.push(e);
            e = faterMap.get(e);
        }

        while (!stack.isEmpty()) {
            faterMap.put(stack.pop(), e);
        }
        return e;
    }

    public boolean isSameUnion(V v1, V v2) {
        if (valueMap.containsKey(v1) && valueMap.containsKey(v2)) {
            return findHead(valueMap.get(v1)) == findHead(valueMap.get(v2));
        }
        return false;
    }

    public void sum(V v1, V v2) {
        Element<V> ev1 = valueMap.get(v1);
        Element<V> ev2 = valueMap.get(v2);
        Element head1 = findHead(ev1);
        Element head2 = findHead(ev2);
        if (head1 != head2) {
            int size1 = sizeMap.get(head1);
            int size2 = sizeMap.get(head2);
            Element big=size1>=size2? head1:head2;
            Element small=size1>=size2? head2:head1;
            faterMap.put(small, big);
            sizeMap.put(big,size1+size2);
            sizeMap.remove(small);
        }
    }


}
