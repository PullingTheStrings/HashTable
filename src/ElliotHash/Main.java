package ElliotHash;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        HashTable<String,String> table=new Hash_Impl<String,String>();
        table.put("Adamson","Elliot");
        System.out.println(table.get("Adamson"));


        int size=10000;
        table=new Hash_Impl();
        Random rand=new Random();

    for (int i = 0; i < 2500; i++) {



          table.put(""+rand.nextInt(size), ""+rand.nextInt(size));



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
        System.out.println(table.get(""+rand.nextInt(size)));
    }





}
