package model.product;

import model.product.interfaces.Expirable;
import model.product.interfaces.Shippable;

import java.time.LocalDate;

public class FullFeaturedProduct extends Product implements Expirable, Shippable {
    private double weight;
    private LocalDate expiryDate;

    public FullFeaturedProduct() {

    }

    public FullFeaturedProduct(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
