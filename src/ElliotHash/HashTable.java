package ElliotHash;

public interface HashTable<T> {

    void put(Object key, T value);
    T get(Object key);

    int getCollisions();







}
