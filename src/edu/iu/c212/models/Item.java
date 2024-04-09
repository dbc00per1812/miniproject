package edu.iu.c212.models;

public class Item {
    private String name;
    private double price;
    private int quantity;
    private int aisleNum;

    public Item(String name, double price, int quantity, int aisleNum) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.aisleNum = aisleNum;
    }

    // Getter and setter methods
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getAisle() { return aisleNum; }
    public void setAisle(int aisleNum) { this.aisleNum = aisleNum; }

    @Override
    public String toString() {
        return String.format("Item{name='%s', price=%.2f, quantity=%d, aisleNum=%d}", name, price, quantity, aisleNum);
    }
}
