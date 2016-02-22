public class Entry<Key, Value> {
    Key key;
    Value value;
    Entry<Key, Value> nextBucket;

    public Entry(Key key, Value value, Entry<Key, Value> nextBucket) {
        this.key = key;
        this.value = value;
        this.nextBucket = nextBucket;
    }
}
