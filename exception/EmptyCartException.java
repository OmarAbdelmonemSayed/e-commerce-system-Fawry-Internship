package exception;

public class EmptyCartException extends RuntimeException {
    public EmptyCartException() {
        super("Cart is empty. Cannot proceed to checkout.");
    }
}