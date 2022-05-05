package ElliotHash;

import java.util.Iterator;

public class Set<T> implements Iterable<T> {

    private List<T> list;
    private LimitedHashTable<T> table;

    public Set() {
        list=new List<>();
        table=new LimitedHashTableImpl<>(100000);
    }
    public void put(T thing){
        if(!table.contains(thing)){
            table.put(thing);
            list.add(thing);
        }
    }
    public void remove(T thing){

        list.remove(thing);
    }
    public boolean contains(T thing){
        return table.contains(thing);
    }
    public Iterator<T> iterator(){
        Iterator<T> iterator=new ListIterator(list);
        return iterator;
    }
}
