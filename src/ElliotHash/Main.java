package ElliotHash;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int size=10000;
        HashTable<String> table=new Hash_Impl();
        Random rand=new Random();
        boolean[] random1=new boolean[size];
    for (int i = 0; i < 2500; i++) {
      boolean bool = true;
      while (bool) {
        int index = rand.nextInt(size); // pick a random number between 1 and 10000
        if (random1[index] == false) { // if the number hasn't been taken
          random1[index] = true; // indicate that the number is now taken

          table.put(index, "Duh");
          bool = false; // get out of the while loop
        }
      }
        }
    System.out.println(table.getCollisions());
        boolean[] random2=new boolean[size];
        int collisions=0;
        for(int i=0;i<2500;i++){
            int index=rand.nextInt(size);
            if(random2[index]==false){
                random2[index]=true;
            }
            else{
                collisions++;
            }
        }//this block of code will randomly distribute 2500 trues in an array of 10000
        //it also records the number of collisions (when it tries to make an already true slot true)
        System.out.println(collisions);
        System.out.println(table.get(rand.nextInt(size)));
    }





}
