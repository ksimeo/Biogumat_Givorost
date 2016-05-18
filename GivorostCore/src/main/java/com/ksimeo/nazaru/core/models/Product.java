package com.ksimeo.nazaru.core.models;

import javax.persistence.*;

/**
 * Created by @author Ksimeo on 26.01.2015
 */
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
//    , unique = true)
    private String name;
    @Column
    private Float price;
    @Column
    private Float factor;

    public Product() { }

    public Product(String name, float price, float factor) {
        this.name = name;
        this.price = price;
        this.factor = factor;
    }

    public Product(int id, String name, float price, float factor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.factor = factor;
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price +
                ", factor='" + factor +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (factor != null ? factor.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (factor != null ? !factor.equals(product.factor) : product.factor != null) return false;

        return true;
    }
}