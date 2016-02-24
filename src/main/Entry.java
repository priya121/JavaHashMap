package main;

public class Entry<Key, Value> {
    Key key;
    Value value;
    Entry<Key, Value> nextNode;

    public Entry(Key key, Value value, Entry<Key, Value> nextNode) {
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
    }
}
