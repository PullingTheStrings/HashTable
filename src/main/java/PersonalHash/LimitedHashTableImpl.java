package PersonalHash;

public class LimitedHashTableImpl<T> implements LimitedHashTable<T> {
    private int size; // size of hash table
    private double decimal=5;
    private List<T>[] array;  // this is the array in which data is added
    public LimitedHashTableImpl(int size) {
        this.size=(int)Math.pow(10,Math.ceil((Math.log10(size))));
        array= new List[size];

    }

    @Override
    public void put(T value) { // makes a pair with the key and the value and adds it to the array
        if(value==null){
            throw new IllegalArgumentException();
        }


        // the reason why a pair is needed is that the key and value must always be linked
        // otherwise, the data structure would have no way of differentiating between the same value
        // hashed with different keys
        insert(value);

    }

    private void insert(T pair) { // finds the hash value and puts the pair there
        int index = hash(pair.hashCode()); // gets the value from the hash function

        if (array[index] == null) { // if the space in the array is fresh
            List<T> chain = new List(); // create a new list

            chain.add(pair); // add the value to the list (it will be by itself)
            array[index] = chain; // make the list what the array points to
        } else { // there is a collision and a list already exists
            for(T element:array[index]){
                if(pair.equals(element)){
                    throw new DuplicateKeyException();
                }
            }
            array[index].add(pair); // add the value to the existing list

        }
    }
    private int hash(int key){
        return HashFunction.hash(key,decimal,size);
    }
    @Override
    public T get(T key) {
        if(key==null){
            throw new IllegalArgumentException();
        }
        List<T> list=array[hash(key.hashCode())]; //use the hash function to find where the value should be
        //and store this as list

        Node<T> currentNode;
        try {
            currentNode = list.getHead();
        } // set the current node to be the head of the chain
        catch (NullPointerException e) { // if there is no chain
            // System.out.println("Not here");
            return null;
        }
        // if the program makes it to this point then there will be a chain

        for(T thing:list){
            if(thing.equals(key)){
                return thing;
            }
        }
        return null;
    }
    @Override
    public boolean contains(T thing){
        return get(thing)!=null;
    }
    @Override
    public void remove(T thing){
        if(contains(thing)){
            List<T> list=array[hash(thing.hashCode())];
            list.remove(thing);
            if(list.size()==0){
                array[hash(thing.hashCode())]=null;
            }
        }
    }

}
