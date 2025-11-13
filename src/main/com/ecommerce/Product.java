package com.ecommerce;

public class Product {
    private int id;
    private String name, description, image;
    private double price;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String n) { this.name = n; }
    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }
    public String getImage() { return image; }
    public void setImage(String i) { this.image = i; }
    public double getPrice() { return price; }
    public void setPrice(double p) { this.price = p; }
}
