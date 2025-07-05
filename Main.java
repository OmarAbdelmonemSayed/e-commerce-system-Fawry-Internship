
import model.cart.*;
import model.customer.*;
import model.product.*;
import service.*;
import exception.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // ASSUMPTIONS:
        // - Assumes weights are in kg
        // - Assumes product quantity ≥ 0 and balance ≥ 0"


        // Products
        Product cheese = new FullFeaturedProduct("Cheese", 30.0, 3, 0.4, LocalDate.now().plusDays(1));
        Product tv = new ShippableProduct("TV", 1000.0, 2, 5.0);
        Product biscuit = new ExpirableProduct("Biscuits", 5.0, 8, LocalDate.now().minusDays(1));
        Product mobile = new BasicProduct("Mobile", 350.0, 3);


        // Customers
        Customer normalCustomer = new Customer("Alice", 3000.0);
        Customer brokeCustomer = new Customer("Bob", 100.0);
        Customer emptyCartCustomer = new Customer("Eve", 500.0);
        Customer expiredProductCustomer = new Customer("Zara", 500.0);
        Customer outOfStockCustomer = new Customer("Max", 5000.0);



        // CASE: NORMAL CHECKOUT
        System.out.println("=== Normal Checkout ===");
        try {

            Cart cart1 = new Cart();
            cart1.add(cheese, 2);
            cart1.add(tv, 1);
            cart1.add(mobile, 1);
            CheckoutService.checkout(normalCustomer, cart1);

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }



        // CASE: EMPTY CART CHECKOUT
        System.out.println("\n=== Empty Cart Checkout ===");
        try {

            Cart cart2 = new Cart();
            CheckoutService.checkout(emptyCartCustomer, cart2);

        } catch (EmptyCartException e) {
            System.out.println("[EXPECTED] " + e.getMessage());
        }



        // CASE: EXPIRED PRODUCT
        System.out.println("\n=== Expired Product ===");
        try {

            Cart cart3 = new Cart();
            cart3.add(biscuit, 1);
            CheckoutService.checkout(expiredProductCustomer, cart3);

        } catch (ExpiredException e) {
            System.out.println("[EXPECTED] " + e.getMessage());
        }



        // CASE: OUT OF STOCK
        System.out.println("\n=== Out of Stock ===");
        try {

            Cart cart4 = new Cart();
            cart4.add(tv, 10);
            CheckoutService.checkout(outOfStockCustomer, cart4);

        } catch (OutOfStockException e) {
            System.out.println("[EXPECTED] " + e.getMessage());
        }



        // CASE: INSUFFICIENT BALANCE
        System.out.println("\n=== Insufficient Balance ===");
        try {

            Cart cart5 = new Cart();
            cart5.add(tv, 1);
            CheckoutService.checkout(brokeCustomer, cart5);

        } catch (InsufficientBalanceException e) {
            System.out.println("[EXPECTED] " + e.getMessage());
        }

    }
}
