package a0;

public interface HashTable<T> {

    void insert(Pair<T> pair);
    T get(int key);

    int getCollisions();







}
