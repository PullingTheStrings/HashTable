package PersonalHash;

import java.lang.Math;

public class Hash_Impl<S, T> implements HashTable<S, T> {

    private int size; // size of hash table
    private double decimal = 5;//to be used as an argument in the hash function
    private int collisions = 0; // keeps track of the number of collisions as data is added
    private List<Pair<S, T>>[] array;  // this is the array in which data is added
    // as "List" implies, this implementation uses chaining
    private Set<S> keySet;
    private Set<T> valueSet;

    public Hash_Impl(int size) {
        if (size < 100) {
            throw new IllegalArgumentException(); // let's not deal with arrays that are unnecessarily small
        }
        this.size = (int) Math.pow(10, Math.ceil((Math.log10(size))));
        //round up the size to the nearest power of 10 and make that the size of the array
        array = new List[size];
        keySet = new Set<>();
        valueSet = new Set<>();
    }


    @Override
    public void put(
            S key, T value) { // makes a pair with the key and the value and adds it to the array
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        if (keySet().contains(key)) {
            throw new DuplicateKeyException();//keys must be unique
        }
        Pair<S, T> pair = new Pair(key, value);
        // The reason why a pair is needed is that the key and value must always be linked.
        // Otherwise, the data structure would have no way of differentiating between the same value
        // hashed with different keys (if those keys happen to cause a collision).
        insert(pair); // this private method does the work of putting the pair where it needs to go in the array
        keySet.put(key);
        valueSet.put(value);
    }

    private void insert(Pair<S, T> pair) { // finds the hash value and puts the pair there
        int index = hash(pair.getKey().hashCode()); // gets the array index value from the hash function

        if (array[index] == null) { // if the space in the array is fresh
            List<Pair<S, T>> chain = new List(); // then create a new list

            chain.add(pair); // add the value to the list (it will be by itself)
            array[index] = chain; // make the list what the array points to
        } else { //there is a collision and a list already exists
            array[index].add(pair); // add the value to the existing list
            collisions++; // keep track of this new collision
        }
    }

    private int hash(int key) {
        return HashFunction.hash(key, decimal, size);
    }


    public int getCollisions() {
        return collisions;
    } // for measuring how good the hash function is

    private List<Pair<S, T>> getList(S key) { // private getter for a chain where a particular key hashes to
        int location = hash(key.hashCode());
        return array[location];
    }

    @Override
    public T get(S key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        List<Pair<S, T>> list = getList(key);


        Node<Pair<S, T>> currentNode;
        try {
            currentNode = list.getHead();
        } // set the current node to be the head of the chain
        catch (NullPointerException e) { // if there is no chain

            return null;
        }
        // if the program makes it to this point then there will be a chain

        for (Pair<S, T> thing : list) {
            if (thing.getKey().equals(key)) {
                return thing.getValue();
            }
        }
        throw new RuntimeException("This line shouldn't have been reached");
    }

    @Override
    public Set<S> keySet() {
        return keySet;
    }

    @Override
    public Set<T> valueSet() {
        return valueSet;
    }

    @Override
    public void remove(T thing) { // removes the value specified and updates the sets
        if (thing != null) {


            for (S key : keySet) {

                List<Pair<S, T>> list = array[hash(key.hashCode())];
                int prevListSize = list.size();
                //get the list of all the things that hashed to the same place as key
                Pair<S, T> pair = new Pair(key, thing);
                // this pair is what we will compare each element of the list to
                for (Pair<S, T> element : list) {
                    if (element.equals(pair)) { // this is true when we find the element that we need to remove
                        list.remove(element); //removes the element from the list
                        keySet.remove(key); // removes its key
                        break;
                    }
                }
                if (list.size() == 0) {
                    array[hash(key.hashCode())] = null; //We don't want a list of size 0

                } else {
                    collisions = collisions - prevListSize + list.size();//updates the number of collisions
                }


            }
            valueSet.remove(thing);
            //so at this point, every trace of thing has been removed from the actual table
        }
    }

    @Override
    public boolean contains(T thing) { // this method works by using the get method to see if what it returns isn't null
        if (thing == null) {
            throw new IllegalArgumentException();
        }

        for (S key : keySet) {
            try {
                if (thing.equals(get(key))) {
                    return true;
                }
            } catch (NullPointerException e) {
            }
        }
        return false;
    }

    private void resize() { // still a work in progress
        size = size * 10;
    }
}
