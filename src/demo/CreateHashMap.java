package demo;

public class CreateHashMap<K, V> {
    class Entry<K, V> {
        private K key;
        private V value;
        private int hash;
        private Entry next;

        public Entry(K key, V value, int hash, Entry next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private Entry<K, V>[] table;
    private int size;

    public CreateHashMap() {
        this.table = new Entry[16];
    }

    public V put(K key, V value) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            table[index] = new Entry<>(key, value, index, null);
            size++;
        } else {
            table[index] = new Entry<>(key, value, index, entry);
        }
        return table[index].getValue();
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % 15);
    }


    public V get(K key) {
        if (size == 0) {
            return null;
        }
        int index = hash(key);
        Entry<K, V> entry = getEntry(key, index);
        return entry == null ? null : entry.getValue();
    }

    private Entry<K, V> getEntry(K key, int index) {
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.hash == index && (e.getKey().equals(key) || e.key == key)) {
                return e;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CreateHashMap<String, String> hashMap = new CreateHashMap<>();
        hashMap.put("1", "1");
        hashMap.put("2", "2");
        hashMap.get("2");
        System.out.println(hashMap.get("2"));
        System.out.println(hashMap.size());
    }

}

