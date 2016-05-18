package com.ksimeo.nazaru.core.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by @Ksimeo on 26.01.2015
 */
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private Date date;
    @Column
    private String name;
    @Column
    private String tel;
    @Column
    private String email;
    @Column
    private String region;
    @Column
    private String productName;
    @Column
    private Long number;
    @Column(name = "date_of_considered")
    private Date considerDate;
    @Column(name="log_of_considered")
    private String considerLogin;


    //    public Order(String tel, String email, String region, int productId, int number) {
//
//        this.date = new Date();
//        this.tel = tel;
//        this.email = email;
//        this.region = region;
//        this.productId = productId;
//        this.number = number;
//    }

    public Order(String name, String tel, String email, String region, String productName, long number) {

        this.date = new Date();
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.region = region;
        this.productName = productName;
        this.number = number;
    }

    public Order(int id, String name, String tel, String email, String region, String productName, long number) {

        this.id = id;
        this.date = new Date();
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.region = region;
        this.productName = productName;
        this.number = number;
    }

    public Order(int id, Date date, String name, String tel, String email, String region, String productName, long number) {

        this.id = id;
        this.date = date;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.region = region;
        this.productName = productName;
        this.number = number;
    }


    public Order() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getConsiderDate() {
        return considerDate;
    }

    public void setConsiderDate(Date considerDate) {
        this.considerDate = considerDate;
    }

    public String getConsiderLogin() {
        return considerLogin;
    }

    public void setConsiderLogin(String considerLogin) {
        this.considerLogin = considerLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (name != null ? !name.equals(order.name) : order.name != null) return false;
        if (tel != null ? !tel.equals(order.tel) : order.tel != null) return false;
        if (email != null ? !email.equals(order.email) : order.email != null) return false;
        if (region != null ? !region.equals(order.region) : order.region != null) return false;
        if (productName != order.productName) return false;
        if (number != null ? !number.equals(order.number) : order.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + productName.hashCode();
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nOrder{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", region='" + region + '\'' +
                ", productId='" + productName + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}