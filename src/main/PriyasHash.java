package main;

public class PriyasHash<Key, Value> {
    private final Entry<Key, Value>[] table;

    public PriyasHash() {
        this.table = new Entry[3];
    }

    public Entry<Key, Value> add(Key key, Value value) {
        int hashCode = calculateHashCode(key);
        Entry<Key, Value> newEntry = new Entry<>(key, value, null);

        if (table[hashCode] == null) {
            table[hashCode] = newEntry;
        } else {
            append(hashCode, newEntry);
        }
        return newEntry;
    }

    private void append(int hashCode, Entry<Key, Value> newEntry) {
        Entry<Key, Value> endOfList = getLastEntry(null, table[hashCode]);
        endOfList.nextNode = newEntry;
    }

    private Entry<Key, Value> getLastEntry(Entry<Key, Value> previousValue, Entry<Key, Value> currentEntry) {
        while (currentEntry != null) {
            previousValue = currentEntry;
            currentEntry = currentEntry.nextNode;
        }
        return previousValue;
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
