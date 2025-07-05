# 🛒 E-Commerce System

This project simulates a simple console-based e-commerce system written in Java. It models real-world product types, customer behavior, and business rules like product expiry, shipping, and purchase limitations.

---

## 📦 Features

- Abstract product hierarchy with multiple behaviors:
    - Shipable products (require shipping weight)
    - Expirable products (have expiration dates)
- Cart and customer system for adding and purchasing products
- Custom exceptions for clean error handling
- Shipping service that collects all shippable items
- Console-based checkout summary with subtotal, shipping, and remaining balance

---
## 📂 Project Structure
- `model/`
    - `product/`
        - `Product.java`
        - `FullFeaturedProduct.java`
        - `ShipableProduct.java`
        - `ExpirableProduct.java`
        - `BasicProduct.java`
        - `interfaces/`
            - `Shipable.java`
            - `Expirable.java`
    - `customer/`
        - `Customer.java`
    - `cart/`
        - `Cart.java`
        - `CartItem.java`
- `service/`
    - `CheckoutService.java`
    - `ShippingService.java`
- `exception/`
    - `OutOfStockException.java`
    - `EmptyCartException.java`
    - `ExpiredException.java`
    - `InsufficientBalanceException.java`
- `Main.java`

---
## 🛠 How to Run

1. Clone the repository and open it in IntelliJ IDEA (or any Java IDE):
   ```bash
   git clone https://github.com/OmarAbdelmonemSayed/e-commerce-system-Fawry-Internship.git
