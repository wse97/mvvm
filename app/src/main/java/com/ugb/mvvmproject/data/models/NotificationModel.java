package com.ugb.mvvmproject.data.models;

public class NotificationModel {
    int id;
    String title;
    String body;
    String created_at;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getCreated_at() {
        return created_at;
    }
}
