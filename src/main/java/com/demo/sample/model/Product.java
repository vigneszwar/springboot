package com.demo.sample.model;



public class Product {
    private long id;
    private String name;
    private String description;
    private long price;

    public Product() {

    }

    public Product(long id, String name, String description, long price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getPrice() {
        return price;
    }



}
