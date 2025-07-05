package service;

import model.cart.*;
import model.product.*;
import model.product.interfaces.Shippable;

import java.util.List;

public class ShippingService {
    public static int  calculateShippingFees(List<CartItem> cartItems) {
        int shipping = 0;
        for (CartItem cartItem : cartItems) {
            shipping += cartItem.getQuantity() * cartItem.getProduct().getPrice()
                    * ((int)((Shippable) cartItem.getProduct()).getWeight()) / 100;
        }
        return shipping;
    }
}
