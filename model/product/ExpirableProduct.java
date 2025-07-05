package model.product;

import model.product.interfaces.Expirable;

import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable {
    private LocalDate expiryDate;

    public ExpirableProduct() {

    }

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

}
