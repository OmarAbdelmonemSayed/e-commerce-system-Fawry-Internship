package service;

import exception.*;
import model.cart.*;
import model.customer.Customer;
import model.product.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        List<CartItem> cartItems = cart.getProducts();

        if (cartItems.isEmpty()) {
            throw new EmptyCartException();
        }

        double subTotal = 0;

        List<CartItem> shipableCartItems = new ArrayList<>();

        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct() instanceof Expirable && (((Expirable) cartItem.getProduct()).isExpired())) {
                throw new ExpiredException(cartItem.getProduct().getName());
            }

            if (cartItem.getProduct().getQuantity() < cartItem.getQuantity()) {
                throw new OutOfStockException(cartItem.getProduct().getName());
            }

            if (cartItem.getProduct() instanceof Shipable) {
                shipableCartItems.add(cartItem);
            }

            subTotal += cartItem.getProduct().getPrice() * cartItem.getQuantity();
            cartItem.getProduct().setQuantity(cartItem.getProduct().getQuantity() - cartItem.getQuantity());
        }

        int shipping = ShippingService.calculateShippingFees(shipableCartItems);

        int amount = (int)Math.round(subTotal) + shipping;

        if (customer.getBalance() < amount) {
            throw new InsufficientBalanceException();
        }

        customer.setBalance(customer.getBalance() - amount);

        int totalWeight = 0;

        System.out.println("** Shipment notice **");

        for (CartItem cartItem : shipableCartItems) {
            totalWeight += (int)(((Shipable)cartItem.getProduct()).getWeight() * cartItem.getQuantity() * 1000);
            System.out.printf("%-20s %5s\n", cartItem.getQuantity() + "x " + cartItem.getProduct().getName(),
                    (int)(((Shipable)cartItem.getProduct()).getWeight() * cartItem.getQuantity() * 1000) + "g");
        }

        System.out.println("Total package weight " + (double)totalWeight / 1000 + "kg\n");

        System.out.println("** Checkout receipt **");

        for (CartItem cartItem : cartItems) {
            System.out.printf("%-20s %5s\n", cartItem.getQuantity() + "x " + cartItem.getProduct().getName(),
                    (int)(cartItem.getQuantity() * cartItem.getProduct().getPrice()));
        }


        System.out.println("----------------------");
        System.out.printf("%-20s %5s\n", "Subtotal", Math.round(subTotal));
        System.out.printf("%-20s %5s\n", "Shipping", shipping);
        System.out.printf("%-20s %5s\n", "Amount",  amount);
        System.out.printf("%-20s %5s\n", "Customer's balance is ", Math.round(customer.getBalance()));
    }
}
