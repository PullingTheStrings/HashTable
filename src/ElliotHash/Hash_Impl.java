package ElliotHash;

import java.lang.Math;

public class Hash_Impl<S,T> implements HashTable<S,T> {

  private int size = 100000000; // size of hash table
  private double decimal=5;
  private int collisions = 0; // keeps track of the number of collisions as data is added
  private List<Pair<S,T>>[] array = new List[size]; // this is the array in which data is added

  public Hash_Impl() {}

  // array of lists of pairs

  @Override
  public void put(
      S key, T value) { // makes a pair with the key and the value and adds it to the array
    Pair<S,T> pair = new Pair<S,T>(key, value);
    // the reason why a pair is needed is that the key and value must always be linked
    // otherwise, the data structure would have no way of differentiating between the same value
    // hashed with different keys
    insert(pair);
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
    double log = Math.log(Math.abs(key) + 1);
    double m = Math.pow(10,decimal) * log - Math.floor(Math.pow(10,decimal) * log);
    // 1: take the absolute value of the number and add 1
    // 2:take the log of this number
    // 3: move the decimal point 5 spots to the right
    // 4: delete everything to the left of the decimal point
    int finalNumber = 0;
    int digits = (int) Math.floor(Math.log10(size)); // the number of digits that we take from this number
    for (int digit = 0; digit < digits; digit++) {
      int i = (int) Math.floor(10 * m);
      finalNumber = finalNumber + (int) (i * Math.pow(10, digits - 1 - digit));
      m = 10 * m - i;
    }
    return finalNumber; // this number will be the array index slot
  }


  public int getCollisions() {
    return collisions;
  } // for measuring how good the hash function is
  @Override
  public T get(S key) {
    int location = hash(key.hashCode());
    List<Pair<S,T>> list=array[location];


    Node<Pair<S,T>> currentNode;
    try {
      currentNode = array[location].getHead();
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
      if(thing.getKey()==key){
        return thing.getValue();
      }
    }
    throw new RuntimeException("This line shouldn't have been reached");
  }
  private void resize(){
    size=size*10;
  }
}
