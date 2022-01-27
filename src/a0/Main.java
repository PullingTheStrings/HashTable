package a0;
import java.util.Random;
public class Main {
    public static void main(String[] args) {


        HashTable table=new Hash_Impl();
        Random rand=new Random();

        for(int i=0;i<2500;i++){
            List list=new List();
            for(int j=0;j<5;j++){
                list.add(rand.nextInt(26)+1);
            }
            table.insert(list);
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
        }
        System.out.println(collisions);

    }




}
