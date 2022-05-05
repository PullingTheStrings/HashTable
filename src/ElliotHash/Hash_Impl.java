package ElliotHash;

import java.lang.Math;

public class Hash_Impl<S,T> implements HashTable<S,T> {

  private int size; // size of hash table
  private double decimal=5;
  private int collisions = 0; // keeps track of the number of collisions as data is added
  private List<Pair<S,T>>[] array;  // this is the array in which data is added
  private Set<S> keySet;
  private Set<T> valueSet;

  public Hash_Impl(int size) {
    this.size=(int)Math.pow(10,Math.ceil((Math.log10(size))));
    array= new List[size];
    keySet=new Set<>();
    valueSet=new Set<>();
  }

  // array of lists of pairs

  @Override
  public void put(
      S key, T value) { // makes a pair with the key and the value and adds it to the array
    if(key==null||value==null){
      throw new IllegalArgumentException();
    }
    if(keySet().contains(key)){
      throw new DuplicateKeyException();
    }
    Pair<S,T> pair = new Pair<S,T>(key, value);
    // the reason why a pair is needed is that the key and value must always be linked
    // otherwise, the data structure would have no way of differentiating between the same value
    // hashed with different keys
    insert(pair);
    keySet.put(key);
    valueSet.put(value);
  }

  private void insert(Pair<S,T> pair) { // finds the hash value and puts the pair there
    int index = hash(pair.getKey().hashCode()); // gets the value from the hash function

    if (array[index] == null) { // if the space in the array is fresh
      List<Pair<S,T>> chain = new List(); // create a new list

      chain.add(pair); // add the value to the list (it will be by itself)
      array[index] = chain; // make the list what the array points to
    } else { // there is a collision and a list already exists
      array[index].add(pair); // add the value to the existing list
      collisions++; // keep track of this new collision
    }
  }

  private int hash(int key) {
    return HashFunction.hash(key,decimal,size);
  }


  public int getCollisions() {
    return collisions;
  } // for measuring how good the hash function is
  private List<Pair<S,T>> getList(S key){
    int location = hash(key.hashCode());
    return array[location];
  }
  @Override
  public T get(S key) {
    if(key==null){
      throw new IllegalArgumentException();
    }
    List<Pair<S,T>> list=getList(key);


    Node<Pair<S,T>> currentNode;
    try {
      currentNode = list.getHead();
    } // set the current node to be the head of the chain
    catch (NullPointerException e) { // if there is no chain
      // System.out.println("Not here");
      return null;
    }
    // if the program makes it to this point then there will be a chain
    if (currentNode.getValue().getKey().equals(key)) {
      return currentNode.getValue().getValue();
    }
    // see if the head matches and enter the loop otherwise
    for(Pair<S,T> thing:list){
      if(thing.getKey().equals(key)){
        return thing.getValue();
      }
    }
    throw new RuntimeException("This line shouldn't have been reached");
  }
  @Override
  public Set<S> keySet(){
    return keySet;
  }
  @Override
  public Set<T> valueSet(){
    return valueSet;
  }
  @Override
  public void remove(T thing){
    if (thing != null) {

      for (S key : keySet) {
        List<Pair<S, T>> list = array[hash(key.hashCode())];
        Pair<S, T> pair = new Pair(key, thing);

          list.remove(pair);
          keySet.remove(key);
      }
    }
  }
  @Override
  public boolean contains(T thing){
    if(thing==null){
      throw new IllegalArgumentException();
    }

    for(S key:keySet){
      if(thing.equals(get(key))){
       return true;
      }
    }
    return false;
  }
  private void resize(){
    size=size*10;
  }
}
