package exception;

public class ExpiredException extends RuntimeException {
    public ExpiredException(String productName) {
        super("Product '" + productName + "' is expired and can't be purchased.");
    }
}