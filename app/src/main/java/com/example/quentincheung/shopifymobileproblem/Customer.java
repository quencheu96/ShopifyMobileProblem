package com.example.quentincheung.shopifymobileproblem;

/**
 * Created by Quentin Cheung on 9/10/2017.
 */

import com.google.gson.annotations.SerializedName;

class Customer {

    @SerializedName("first_name")
    String firstName;
    @SerializedName("last_name")
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
