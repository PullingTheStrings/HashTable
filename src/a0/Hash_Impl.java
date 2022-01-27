package a0;
import java.lang.Math;
public class Hash_Impl implements HashTable{

    private int size;
    private int collisions=0;
    private DoubleList[] array=new DoubleList[100000000];
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
        Node currentNode=list.getHead();
        int intermediateNumber= 31+currentNode.getValue();
        currentNode=currentNode.getNext();
        while(currentNode!=null){

            intermediateNumber=31*intermediateNumber+ currentNode.getValue();
            currentNode=currentNode.getNext();
        }
        double m=100000*Math.log(intermediateNumber)-Math.floor(100000*Math.log(intermediateNumber));
        int finalNumber=0;
        int digits=4;
        for(int digit=0;digit<digits;digit++){
            int i=(int) Math.floor(10*m);
            finalNumber=finalNumber+(int) (i*Math.pow(10,digits-1-digit));
            m=10*m-i;
        }
        return finalNumber;
    }
    public int getCollisions(){
        return collisions;
    }

}
