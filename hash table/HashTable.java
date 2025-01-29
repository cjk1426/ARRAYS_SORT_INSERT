package hash 


import java.util.LinkedList;


public class HashTable {
    // Define the initial capacity of the hash table
    private static final int INITIAL_CAPACITY = 10;
    private LinkedList<Entry>[] table;
    private int size;

    // Constructor to initialize the hash table
    public HashTable() {
        table = new LinkedList[INITIAL_CAPACITY];
        size = 0;
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Define a hash function to map keys to indices in the table
    private int hash(String key) {
        return key.hashCode() % table.length;
    }

    // Insert a key-value pair into the hash table
    public void insert(String key, String value) {
        int index = hash(key);  // Get the index for the key
        LinkedList<Entry> bucket = table[index];

        // Check if the key already exists and update the value
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;  // Update the value if the key is found
                return;
            }
        }

        // If key is not found, insert a new key-value pair
        bucket.add(new Entry(key, value));
        size++;

        // Check if the load factor is exceeded and resize if necessary
        if (size > table.length * 0.7) {
            resize();
        }
    }

    // Resize the hash table by doubling its size
    private void resize() {
        LinkedList<Entry>[] oldTable = table;
        table = new LinkedList[oldTable.length * 2];
        size = 0;

        // Rehash all entries and insert them into the new table
        for (LinkedList<Entry> bucket : oldTable) {
            for (Entry entry : bucket) {
                insert(entry.key, entry.value);
            }
        }
    }

    // Search for a key in the hash table
    public String search(String key) {
        int index = hash(key);  // Get the index for the key
        LinkedList<Entry> bucket = table[index];

        // Check if the key exists in the bucket
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;  // Return the value if the key is found
            }
        }

        return null;  // Return null if the key is not found
    }

    // Helper class to store key-value pairs
    private static class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();

        // Insert some key-value pairs into the hash table
        ht.insert("apple", "fruit");
        ht.insert("carrot", "vegetable");
        ht.insert("dog", "animal");

        // Search for keys and print the results
        System.out.println("apple: " + ht.search("apple"));
        System.out.println("carrot: " + ht.search("carrot"));
        System.out.println("dog: " + ht.search("dog"));

        // Insert more items to trigger resizing
        ht.insert("elephant", "animal");
        ht.insert("fig", "fruit");

        // Search again after resizing
        System.out.println("elephant: " + ht.search("elephant"));
        System.out.println("fig: " + ht.search("fig"));
    }
}
