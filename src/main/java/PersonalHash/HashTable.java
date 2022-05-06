package PersonalHash;

public interface HashTable<S,T> {

    void put(S key, T value);
    void remove(T thing);
    T get(S key);
    Set<S> keySet();
    Set<T> valueSet();
    boolean contains(T value);

    int getCollisions();







}
