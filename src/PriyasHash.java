public class PriyasHash<Key, Value> {
    private Entry<Key, Value>[] table = new Entry[10];

    public Entry<Key, Value> add(Key key, Value value) {
        int hashCode = calculateHashCode(key);
        Entry<Key, Value> newEntry = new Entry<>(key, value, null);
        table[hashCode] = newEntry;
        return newEntry;
    }

    public String search(Key key) {
        int hashCode = calculateHashCode(key);
        Entry<Key, Value> temporary = table[hashCode];
        if (temporary.key.equals(key)) {
            return temporary.value.toString();
        } else {
            return "hi";
        }
    }

    private int calculateHashCode(Key key) {
        return key.hashCode() % 10;
    }
}
