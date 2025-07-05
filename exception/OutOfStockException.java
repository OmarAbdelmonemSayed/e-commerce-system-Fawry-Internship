package exception;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String productName) {
        super("Product '" + productName + "' is out of stock or requested quantity exceeds availability.");
    }
}