package com.example.quentincheung.shopifymobileproblem;

/**
 * Created by Quentin Cheung on 9/10/2017.
 */

import com.google.gson.annotations.SerializedName;

class LineItems {
    @SerializedName("title")
    String name;
    @SerializedName("quantity")
    int quantity;

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
