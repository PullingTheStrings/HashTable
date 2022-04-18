package ElliotHash;

public interface HashTable<S,T> {

    void put(S key, T value);
    T get(S key);

    int getCollisions();







}
