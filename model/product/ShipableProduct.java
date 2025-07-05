package model.product;

import model.product.interfaces.Shipable;

public class ShipableProduct extends Product implements Shipable {
    private double weight;

    public ShipableProduct() {

    }

    public ShipableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
