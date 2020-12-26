package com.app.shopwithus.data.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;

    public User(String userId, String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
