public interface PriorityQueue<K,V> {

    void insert(K key, V value);


    Entry<K, V> min();

    Entry<K, V> removeMin();


    int size();


    boolean isEmpty();
}
