package com.menu.entity;


import javax.persistence.*;

@Entity
@Table(name = "menu")
@NamedQuery(name = "Dish.getAll", query = "SELECT d from Dish d")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "weight")
    private double weight;
    @Column(name = "sale")
    private boolean sale;

    public Dish() {
    }

    public Dish(String name, double price, double weight, boolean sale) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.sale = sale;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isSale() {
        return sale;

    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", sale=" + sale +
                '}';
    }
}
