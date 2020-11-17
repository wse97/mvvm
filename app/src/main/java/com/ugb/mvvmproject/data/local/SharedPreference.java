package com.ugb.mvvmproject.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.ugb.mvvmproject.data.models.UserModel;

/**
 * Created by Waseem.Barzaq on 11/25/17.
 */

public class SharedPreference {
    private static SharedPreference sharedPreference = null;
    private static final String PREFS_NAME = "com.limitless.projects";
    private static final String TOKEN = "token";
    private static final String LANGUAGE = "language";
    private static final String UserName = "UserName";
    private static final String IsACTIVE = "IsACTIVE";
    private static final String COUNTRYPRF = "COUNTRYPRF";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String token = null;
    private String language = null;
    private String USER = "USER";
    private String USERSOCIALMEDIA = "USERSOCIALMEDIA";
    private String IsActive = null;
    private String CountryPro = null;
    private static final String IS_LOGIN = "isLogin";
    private static final String BASE_URL = "base_url";
    private Context context;
    private String HOME_CONTENT = "HOME_CONTENT";
    public static SharedPreference getInstance(Context context) {
        if (sharedPreference == null) {
            sharedPreference = new SharedPreference(context);
        }
        return sharedPreference;
    }

    private SharedPreference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void setToken(String token2) {
        token = token2;
        editor.putString(TOKEN, token2).commit();
        setIsLogin();
    }

    public String getToken() {
        if (token != null)
            return token;

        return sharedPreferences.getString(TOKEN, null);
    }

    public void setCountryPro(String CountryPro2) {
        CountryPro = CountryPro2;
        editor.putString(COUNTRYPRF, CountryPro2).commit();
        setIsLogin();
    }

    public String getCountryprf() {
        if (CountryPro != null)
            return CountryPro;

        return sharedPreferences.getString(COUNTRYPRF, null);
    }

    public void setLanguage(String language2) {
        language = language2;
        editor.putString(LANGUAGE, language2).commit();
        setIsLogin();
    }

    public String getLanguage() {
        if (language != null)
            return language;

        return sharedPreferences.getString(LANGUAGE, null);
    }

    public void setUser(UserModel user) {
        Gson gson = new Gson();
        String userString = gson.toJson(user);
        editor.putString(USER, userString).commit();
    }

    public UserModel getUser() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(USER, null);
        UserModel user = gson.fromJson(json, UserModel.class);
        return user;
    }


    public void setIsLogin() {
        editor.putBoolean(IS_LOGIN, true).commit();
    }

    public Boolean getIsLogin() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void clear() {
        editor.clear().commit();
    }

    public void setBaseUrl(String baseUrl) {
        editor.putString(BASE_URL, baseUrl).commit();
    }

    public String getBaseUrl() {
        return sharedPreferences.getString(BASE_URL, null);
    }

    //***

}
