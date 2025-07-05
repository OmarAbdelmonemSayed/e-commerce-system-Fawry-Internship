package exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super("Insufficient balance. Please add funds or remove some items from the cart.");
    }
}