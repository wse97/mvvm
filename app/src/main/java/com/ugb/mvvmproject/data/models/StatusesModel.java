package com.ugb.mvvmproject.data.models;

public class StatusesModel {
    int id;
    int order_id;
    String status;
    String estimated_time;
    int is_active;
    String created_at;
    String icon;
    String status_name;

    public int getId() {
        return id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getStatus() {
        return status;
    }

    public String getEstimated_time() {
        return estimated_time;
    }

    public int getIs_active() {
        return is_active;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getIcon() {
        return icon;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public String getStatus_name() {
        return status_name;
    }
}
