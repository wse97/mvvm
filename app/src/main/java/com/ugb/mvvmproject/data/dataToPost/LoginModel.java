package com.ugb.mvvmproject.data.dataToPost;

public class LoginModel {
    public String email;
    public String password;
    public String android_token;

    public LoginModel(String email, String password, String android_token) {
        this.email = email;
        this.password = password;
        this.android_token = android_token;
    }

}
