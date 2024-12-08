import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// Class for Process
class Process {
    private String name;
    private int executionTime;

    public Process(String name, int executionTime) {
        this.name = name;
        this.executionTime = executionTime;
    }

    public String getName() {
        return name;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    @Override
    public String toString() {
        return name + " (" + executionTime + ")";
    }
}

// Entry implementation
class PQEntry<K, V> implements Entry<K, V> {
    private K key;
    private V value;

    public PQEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

// LinkedPositionalList-based PriorityQueue
class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    private List<Entry<K, V>> list;

    public SortedPriorityQueue(Comparator<K> comp) {
        super(comp);
        list = new LinkedList<>();
    }

    public SortedPriorityQueue() {
        this(new DefaultComparator<>());
    }

    @Override
    public void insert(K key, V value) {
        Entry<K, V> newEntry = new PQEntry<>(key, value);
        int i = 0;

        // Insert into sorted position
        for (Entry<K, V> entry : list) {
            if (compare(key, entry.getKey()) < 0) {
                list.add(i, newEntry);
                return;
            }
            i++;
        }

        // Add to the end if no smaller key found
        list.add(newEntry);
    }

    @Override
    public Entry<K, V> min() {
        if (list.isEmpty()) throw new IllegalStateException("Priority Queue is empty");
        return list.get(0); // The first element is always the minimum
    }

    @Override
    public Entry<K, V> removeMin() {
        if (list.isEmpty()) throw new IllegalStateException("Priority Queue is empty");
        return list.remove(0); // Remove the first element
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

public class SJFSimulation {
    public static void main(String[] args) {
        // Create a sorted priority queue
        SortedPriorityQueue<Integer, Process> queue = new SortedPriorityQueue<>();

        // Add processes to the queue
        queue.insert(5, new Process("P1", 5));
        queue.insert(3, new Process("P2", 3));
        queue.insert(8, new Process("P3", 8));
        queue.insert(2, new Process("P4", 2));

        // Simulate process execution
        System.out.println("Executing processes in SJF order:");
        while (!queue.isEmpty()) {
            Entry<Integer, Process> current = queue.removeMin(); // Process with shortest execution time
            System.out.println("Executing: " + current.getValue());
        }
    }
}
