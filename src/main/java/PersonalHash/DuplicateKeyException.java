package PersonalHash;

public class DuplicateKeyException extends RuntimeException {
    public DuplicateKeyException(String s) {
        super(s);
    }

    public DuplicateKeyException() {
    }
}
