package ElliotHash;

public interface HashTable<T> {

    void put(int key, T value);
    T get(int key);

    int getCollisions();







}
