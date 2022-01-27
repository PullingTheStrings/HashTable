package a0;
import java.lang.Math;
public class Hash_Impl<T> implements HashTable{

    private int size=100000000;//size of hash table
    private int collisions=0;//keeps track of the number of collisions as data is added
    private DoubleList<T>[] array=new DoubleList[size];//this is the array in which data is added
    public Hash_Impl(){

    }


    public void insert(List list){
        int index=hash(list);
        if(array[index]==null){
            DoubleList chain=new DoubleList();
            chain.add(list);
            array[index]=chain;
        }
        else{
            array[index].add(list);
            collisions++;
        }
    }



    private int hash(List list){
        Node currentNode=list.getHead();//gets the head
        int intermediateNumber= 31+currentNode.getKey();//adds 31 to the key
        currentNode=currentNode.getNext();
        while(currentNode!=null){//keep repeating the intermediate number by 31 and adding the next key

            intermediateNumber=31*intermediateNumber+ currentNode.getKey();
            currentNode=currentNode.getNext();
        }
        double m=100000*Math.log(intermediateNumber)-Math.floor(100000*Math.log(intermediateNumber));
        //1: take the log of this number
        //2: move the decimal point 5 spots to the right
        //3: delete everything to the left of the decimal point
        int finalNumber=0;
        int digits=4;//the number of digits that we take from this number
        for(int digit=0;digit<digits;digit++){
            int i=(int) Math.floor(10*m);
            finalNumber=finalNumber+(int) (i*Math.pow(10,digits-1-digit));
            m=10*m-i;
        }
        return finalNumber;//this number will be the array index slot
    }
    public int getCollisions(){
        return collisions;
    }//for measuring how good the hash function is

}
