package ElliotHash;
import java.util.Random;

public class Main {



  public static void main(String[] args) {
    
    getStatistics(10000,1000);

}
public static void getStatistics(int size,int simulations){
  int trials = 0;
  int random = 0;
  int hash = 0;

  int hashMin=size;
  int hashMax=0;
  int randomMin=size;
  int randomMax=0;


  if((int)Math.pow(10,Math.ceil((Math.log10(size))))!=10000){
    throw new ArithmeticException();
  }
  for (int x = 0; x < simulations; x++) {
    HashTable<String, String> table = new Hash_Impl(size);

    Random rand = new Random();
    boolean[] random1 = new boolean[size];
    for (int i = 0; i < size/4; i++) {
      boolean b=true;
      while(b){
        int index=rand.nextInt(size);
        if (random1[index] == false) {
          random1[index]=true;
          table.put("" + index, "" + index);
          b=false;
        }
      }
    }
    //System.out.println(table.getCollisions());
    hash=hash+table.getCollisions();
    hashMin=Math.min(hashMin,table.getCollisions());
    hashMax=Math.max(hashMax,table.getCollisions());
    boolean[] random2 = new boolean[size];
    int collisions = 0;
    for (int i = 0; i < size/4; i++) {
      int index = rand.nextInt(size);
      if (random2[index] == false) {
        random2[index] = true;

      } else {
        collisions++;
      }
    } // this block of code will randomly distribute 2500 trues in an array of 10000
    // it also records the number of collisions (when it tries to make an already true slot true)
    //System.out.println(collisions);
    //System.out.println(table.get("" + rand.nextInt(size)));
    random=random+collisions;
    randomMin=Math.min(randomMin,collisions);
    randomMax=Math.max(randomMax,collisions);
    trials++;
  }
  System.out.println("Average hash collisions: "+hash/trials);
  System.out.println("Average random collisions: "+random/trials);
  System.out.println("Minimum hash collisions: "+hashMin);
  System.out.println("Minimum random collisions: "+randomMin);
  System.out.println("Maximum hash collisions: "+hashMax);
  System.out.println("Maximum random collisions: "+randomMax);
}

}
