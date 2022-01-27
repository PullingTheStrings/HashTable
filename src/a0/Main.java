package a0;
import java.util.Random;
public class Main {
    public static void main(String[] args) {


        HashTable<String> table=new Hash_Impl();
        Random rand=new Random();

        for(int i=0;i<2500;i++){

            for(int j=0;j<5;j++){
                Pair<String> pair=new Pair(rand.nextInt(26)+1,"Duh");
                table.insert(pair);
            }

        }
    System.out.println(table.getCollisions());
        boolean[] random=new boolean[10000];
        int collisions=0;
        for(int i=0;i<2500;i++){
            int index=rand.nextInt(10000);
            if(random[index]==false){
                random[index]=true;
            }
            else{
                collisions++;
            }
        }//this block of code will randomly distribute 2500 trues in an array of 10000
        //it also records the number of collisions (when it tries to make an already true slot true)
        System.out.println(collisions);

    }




}
