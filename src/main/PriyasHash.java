package main;

public class PriyasHash<Key, Value> {
    private final Entry<Key, Value>[] table;

    public PriyasHash() {
        Entry<Key, Value>[] table = new Entry[3];
        this.table = table;
    }

    public Entry<Key, Value> add(Key key, Value value) {
        int hashCode = calculateHashCode(key);
        Entry<Key, Value> newEntry = new Entry<>(key, value, null);

        if (table[hashCode] == null) {
            table[hashCode] = newEntry;
        } else {
            makeLinkedList(key, hashCode, newEntry);
        }
        return newEntry;
    }

    private void makeLinkedList(Key newKey, int hashCode, Entry<Key, Value> newEntry) {
        Entry<Key, Value> previousValue = null;
        Entry<Key, Value> currentEntry = table[hashCode];

        while (currentEntry != null) {
            if (currentEntry.key.equals(newKey)) {
                currentEntry.nextNode = newEntry;
            }
            previousValue = currentEntry;
            currentEntry = currentEntry.nextNode;
        }
        previousValue.nextNode = newEntry;
    }

    public String search(Key key) {
        int hashCode = calculateHashCode(key);
        Entry<Key, Value> entryToCheck = table[hashCode];
        while (entryToCheck != null) {
            if (entryToCheck.key.equals(key)) {
                return entryToCheck.value.toString();
            }
            entryToCheck = entryToCheck.nextNode;
        }
        return null;
    }

    private int calculateHashCode(Key key) {
        return key.hashCode() % 3;
    }
}
