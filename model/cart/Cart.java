package model.cart;

import java.util.ArrayList;
import java.util.List;
import model.product.Product;

public class Cart {
    private List<CartItem> products;

    public Cart() {
        products = new ArrayList<CartItem>();
    }

    public Cart(List<CartItem> products) {
        this.products = products;
    }

    public void add(Product product, int quantity) {
        products.add(new CartItem(product, quantity));

    }

    public List<CartItem> getProducts() {
        return products;
    }

    public void setProducts(List<CartItem> products) {
        this.products = products;
    }
}
