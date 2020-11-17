package com.ugb.mvvmproject.data.models;

public class UserModel {
    int id;
    int city_id;
    String phone;
    String email;
    String name;
    String image;
    int is_active;
    String activation_token;
    String android_token;
    CitiesModel city;

    public int getId() {
        return id;
    }

    public int getCity_id() {
        return city_id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getIs_active() {
        return is_active;
    }

    public String getActivation_token() {
        return activation_token;
    }

    public String getAndroid_token() {
        return android_token;
    }

    public CitiesModel getCity() {
        return city;
    }
}
