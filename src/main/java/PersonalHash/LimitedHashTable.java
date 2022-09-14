package PersonalHash;

public interface LimitedHashTable<T> {//used to avoid stack overflow since it is a field of set objects

    void put(T value);

    void remove(T thing);

    T get(T key);

    boolean contains(T value);
}
