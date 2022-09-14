package PersonalHash;

public class Pair<S, T> {

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair) || o == null) {
            return false;
        }
        Pair pair = (Pair) o;
        boolean equalKeys;
        try {
            equalKeys = pair.getKey().equals(key);
        } catch (NullPointerException e) {
            return key == null;
        }
        boolean equalValues;
        try {
            equalValues = pair.getValue().equals(value);
        } catch (NullPointerException e) {
            return value == null;
        }
        return equalKeys && equalValues;
    }
}
