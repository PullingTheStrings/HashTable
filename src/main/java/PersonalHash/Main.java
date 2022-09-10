package PersonalHash;
import java.util.Random;

public class Main {
//the main class is for testing the efficacy of this hash function


  public static void main(String[] args) {
    
    getStatistics(10000,1000);

}
public static void getStatistics(int size,int simulations){
    /*
    This method performs the following tasks many times (specified by the parameter simulations)
    and then generates some statistics.
    Tasks:
    Create and fill two arrays of the same size in two different ways.
    The first one makes a list of distinct integers and then hashes each of them using the hash table.
    The second one randomly generates integers and puts each one in at the corresponding array index.


     */
  int trials = 0; //keeps track of the number of trials that have been run
  int random = 0; //keeps track of the total number of collisions that occur in the second (random) array across all trials
  int hash = 0;   //keeps track of the total number of collisions that occur in the first (hash) array across all trials

  int hashMin=size; //keeps track of the minimum number of collisions for the first (hash) array
  // that occur in a single trial among the trials already run
  int hashMax=0;
  //keeps track of the maximum number of collisions for the first (hash) array
  // that occur in a single trial among the trials already run
  int randomMin=size;
  //keeps track of the minimum number of collisions for the second (random) array
  // that occur in a single trial among the trials already run
  int randomMax=0;
//keeps track of the maximum number of collisions for the second (random) array
  // that occur in a single trial among the trials already run
  int trueSize=(int)Math.pow(10,Math.ceil((Math.log10(size))));
  //this will be the size of the arrays (round up to the next power of 10)

  for (int x = 0; x < simulations; x++) {//loop that performs the proper number of simulations
    HashTable<String, String> table = new Hash_Impl(trueSize);

    Random rand = new Random();
    boolean[] hashArray = new boolean[trueSize];
    //We will now make some values in this array true.
    //Then we will hash the index values of all the true values and count the collisions.
    for (int i = 0; i < size/4; i++) {//makes some values of the initial array true
      boolean b=true;
      while(b){//ensures that these true values are distinct by making b false only after
        //we find a value to flip from false to true
        int index=rand.nextInt(size);
        if (hashArray[index] == false) {
          hashArray[index]=true;
          table.put("" + index, "" + index);//Once the value has been made true, we hash that index.
          b=false;
        }
      }
    }

    hash=hash+table.getCollisions();//gets the number of collisions caused by all that hashing and adds it to the tally
    hashMin=Math.min(hashMin,table.getCollisions());//updates minimum variable (if needed)
    hashMax=Math.max(hashMax,table.getCollisions());//updates maximum variable (if needed)
    boolean[] randomArray = new boolean[trueSize];
    int collisions = 0;
    //We will now make some values in this array true.
    //However, we will naively assume that we are always flipping values from false to true.
    //In reality, this doesn't happen, so we keep track of the number of times we "flip" a value
    //that is already true and count those as collisions.
    for (int i = 0; i < size/4; i++) {
      int index = rand.nextInt(size);
      if (randomArray[index] == false) {//false to true
        randomArray[index] = true;

      } else {//true to true (collision)
        collisions++;
      }
    }
    random=random+collisions;//gets the number of collisions caused and adds it to the tally
    randomMin=Math.min(randomMin,collisions);//updates the minimum variable (if needed)
    randomMax=Math.max(randomMax,collisions);//updates the maximum variable (if needed)
    trials++;//updates the number of trials performed
  }
  //the lines below print the statistics
  System.out.println("Average hash collisions: "+hash/trials);
  System.out.println("Average random collisions: "+random/trials);
  System.out.println("Minimum hash collisions: "+hashMin);
  System.out.println("Minimum random collisions: "+randomMin);
  System.out.println("Maximum hash collisions: "+hashMax);
  System.out.println("Maximum random collisions: "+randomMax);
}

}
