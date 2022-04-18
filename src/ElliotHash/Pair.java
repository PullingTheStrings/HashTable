package ElliotHash;

import java.util.Objects;

public class Pair<S,T> {

    private S key;
    private T value;

    public Pair(S key, T value) {

        this.key = key;
        this.value = value;
    }

    public S getKey() {
        return key;
    }

    public void setKey(S key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
