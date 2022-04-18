package ElliotHash;

import java.util.Objects;

public class Pair<T> {

    private Object key;
    private T value;

    public Pair(Object key, T value) {

        this.key = key.hashCode();
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key.hashCode();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
