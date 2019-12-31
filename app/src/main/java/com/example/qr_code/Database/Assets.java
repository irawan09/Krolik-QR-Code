package com.example.qr_code.Database;

public class Assets {

    String id;
    String name;
    String description;
    String amount;
    String location;

    public Assets() {
    }

    public Assets(String id, String name, String description, String amount, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
