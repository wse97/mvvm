package com.ugb.mvvmproject.data.models;

import java.util.ArrayList;

public class OrderModel {
    int id;
    String name;
    String description;
    String slug;
    int total_boxes;
    int actual_boxes;
    int remaining_boxes;
    int total_cbm;
    int actual_cbm;
    String price;
    String currency;
    String status;
    String status_name;
    String ashdod_port_est;
    String clearance_est;
    String started_at;
    String done_at;
    String created_at;
    ArrayList<StatusesModel>statuses = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSlug() {
        return slug;
    }

    public int getTotal_boxes() {
        return total_boxes;
    }

    public int getActual_boxes() {
        return actual_boxes;
    }

    public int getRemaining_boxes() {
        return remaining_boxes;
    }

    public int getTotal_cbm() {
        return total_cbm;
    }

    public int getActual_cbm() {
        return actual_cbm;
    }

    public String getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }

    public String getAshdod_port_est() {
        return ashdod_port_est;
    }

    public String getClearance_est() {
        return clearance_est;
    }

    public String getStarted_at() {
        return started_at;
    }

    public String getDone_at() {
        return done_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public ArrayList<StatusesModel> getStatuses() {
        return statuses;
    }

    public String getStatus_name() {
        return status_name;
    }
}
