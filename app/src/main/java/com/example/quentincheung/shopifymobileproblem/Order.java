package com.example.quentincheung.shopifymobileproblem;

/**
 * Created by Quentin Cheung on 9/10/2017.
 */

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Order {


    @SerializedName("total_price")
    double totalPrice;
    @SerializedName("subtotal_price")
    double subtotalPrice;
    @SerializedName("line_items")
    List<LineItems> items;
    @SerializedName("customer")
    Customer customer;


    public double getTotalPrice() {
        return totalPrice;
    }

    public double getSubtotalPrice() {
        return subtotalPrice;
    }

    public List<LineItems> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

}
