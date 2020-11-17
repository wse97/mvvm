package com.ugb.mvvmproject.data.remote.respons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ugb.mvvmproject.data.models.UserModel;

public class UserResponse extends  RootResponse{

    String access_token;
    String token_type;
    @SerializedName("data")
    @Expose
    UserModel userModel;

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public UserModel getUserModel() {
        return userModel;
    }
}
