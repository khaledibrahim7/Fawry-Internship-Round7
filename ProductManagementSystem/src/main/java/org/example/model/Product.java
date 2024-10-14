package org.example.model;

public class Product {

    private String name;
    private double price;
    private String createdBy;

    public Product(String name, double price, String createdBy) {
        this.name = name;
        this.price = price;
        this.createdBy = createdBy;
    }

    public double getPrice() {
        return price;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", createdBy='" + createdBy + "'}";
    }
}
