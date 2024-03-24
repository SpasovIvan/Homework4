package com.spasov.homework4.entity;

public class Product extends Entity{
    private String title;
    private String description;
    private float price;
    private int count;

    public Product () {super();}
    public Product(long id, String title, String description, float price, int count) {
        super(id);
        this.title = title;
        this.description = description;
        this.price = price;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product\n" +
                "ID=" + getId() + "<br>" +
                "Title='" + title + "'<br>" +
                "Description='" + description + "\" '<br>" +
                "Price=" + price + "<br>" +
                "Count=" + count + "<br>";
    }
}
