package ElliotHash;

public interface HashTable<T> {

    void insert(Pair<T> pair);
    T get(int key);

    int getCollisions();







}
