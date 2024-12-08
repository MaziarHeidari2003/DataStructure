import javax.accessibility.AccessibleValue;
import java.util.Comparator;

public  abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {
    protected static class PQEntry<K,V> implements  Entry<K,V> {
        private  K k;
        private  V v;
        public PQEntry(K key,V value){
            k = key;
            v = value;
        }
        public K getKey(){return  k;}
        public V getValue(){return v;}
        protected void setKey(K key){this.k=key;}
        protected void setValue(V value){this.v=value;}

    }
    private Comparator<K> comp;
    protected AbstractPriorityQueue(Comparator<K> c){comp=c;}
    protected AbstractPriorityQueue(){this(new DefaultComparator<K>());}

}
