package a0;
import java.lang.Math;
public class Hash_Impl<T> implements HashTable<T>{

    private int size=100000000;//size of hash table
    private int collisions=0;//keeps track of the number of collisions as data is added
    private List<Pair<T>>[] array=new List[size];//this is the array in which data is added
    public Hash_Impl(){

    }
    //array of lists of pairs

    public void insert(Pair<T> pair){//finds the hash value and puts the pair there
        int index=hash(pair.getKey());//gets the value from the hash function

        if(array[index]==null){//if the space in the array is fresh
            List<Pair<T>> chain=new List();//create a new list

            chain.add(pair);//add the value to the list (it will be by itself)
            array[index]=chain;//make the list what the array points to
        }
        else{//there is a collision and a list already exists
            array[index].add(pair);//add the value to the existing list
            collisions++;//keep track of this new collision
        }
    }



    private int hash(int key){

        double m=100000*Math.log(key)-Math.floor(100000*Math.log(key));
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
    public T get(int key){
        int location=hash(key);
        Node<Pair<T>> currentNode=array[location].getHead();
        if(currentNode.getValue().getKey()==key){return currentNode.getValue().getValue();}
        while(true){
        try{currentNode=currentNode.getNext();
            if(currentNode.getValue().getKey()==key){return currentNode.getValue().getValue();}}
        catch(NullPointerException e){
            System.out.println("Not here");
            return null;
        }

        }
    }
}
