package PersonalHash;

public interface LimitedHashTable<T> {
    void put(T value);
    void remove(T thing);
    T get(T key);
    boolean contains(T value);
}
